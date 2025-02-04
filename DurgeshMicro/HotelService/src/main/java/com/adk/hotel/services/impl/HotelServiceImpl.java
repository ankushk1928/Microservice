package com.adk.hotel.services.impl;

import com.adk.hotel.entities.Hotel;
import com.adk.hotel.exception.ResourceNotFoundException;
import com.adk.hotel.repositories.HotelRepository;
import com.adk.hotel.services.HotelService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author ankushk
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        System.out.println("getHotelById called with id: " + id);
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found:"+id));
    }
}
