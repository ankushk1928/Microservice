package com.adk.user.service.service.impl;

import com.adk.user.service.entities.Hotel;
import com.adk.user.service.entities.Rating;
import com.adk.user.service.entities.User;
import com.adk.user.service.external.service.HotelService;
import com.adk.user.service.repositories.UserRepository;
import com.adk.user.service.service.UserService;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author ankushk
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found in server with given id: "+userId));
        Rating[] ratingsByUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, Rating[].class);
        List<Rating> hotellist= Arrays.stream(ratingsByUser).map(rating -> {
            //using resttemplate
            //Hotel hotel=restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            //using FeignClient
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        List<Rating> ratingList=Arrays.stream(ratingsByUser).toList();
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
