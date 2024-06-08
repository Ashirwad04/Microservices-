package com.rating.RatingService.service;


import com.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    //create rating


    Rating createRating(Rating rating);


    //get all rating

    List<Rating> getAllRatings();


    //get all  rating by user id

    List<Rating> getRetingByUserId(String userId);


    //get all by hotel

    List<Rating> getRatingByHotelId(String hotelId);
}
