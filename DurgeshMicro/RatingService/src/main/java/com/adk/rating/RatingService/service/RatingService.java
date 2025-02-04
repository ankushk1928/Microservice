package com.adk.rating.RatingService.service;

import com.adk.rating.RatingService.entities.Rating;

import java.util.List;

/**
 * @author ankushk
 */


public interface RatingService {
    Rating create(Rating rating);
    List<Rating> getAllRating();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
