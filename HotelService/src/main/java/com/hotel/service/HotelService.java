package com.hotel.service;

import com.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel createHotel(Hotel hotel);

    //get all

    List<Hotel> getAllHotels();



    //get by id

    Hotel getById(String id);


}

















