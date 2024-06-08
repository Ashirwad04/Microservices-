package com.hotel.service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService{


    @Autowired
    private HotelRepository hotelRepository;



 //create hotel
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
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with the give id"+id));

    }


}





















