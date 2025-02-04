package com.adk.rating.RatingService.service.impl;

import com.adk.rating.RatingService.entities.Rating;
import com.adk.rating.RatingService.repositories.RatingRepository;
import com.adk.rating.RatingService.service.RatingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author ankushk
 */

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository  ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String id= UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
