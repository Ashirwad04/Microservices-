package com.hotel.controller;


import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;

    //create hotel

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    //get hotel by id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(hotelId));
    }

    //get All hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }








}










