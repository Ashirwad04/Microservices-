package com.rating.RatingService.controller;


import com.rating.RatingService.entity.Rating;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;


    //create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //get all rating

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    //get all rating by user id

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRetingByUserId(userId));
    }

    //get all rating by Hotel id

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }





}















































