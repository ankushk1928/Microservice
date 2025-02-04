package com.adk.hotel.services;

import com.adk.hotel.entities.Hotel;

import java.util.List;

/**
 * @author ankushk
 */
public interface HotelService {

     Hotel createHotel(Hotel hotel);
     List<Hotel> getAllHotels();
     Hotel getHotelById(String id);
}
