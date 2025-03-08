package com.springboot.web.services;

import java.util.List;
import java.util.Optional;

import com.springboot.web.entities.Hotel;

public interface HotelService {
public Hotel addHotel(Hotel hotel);
public List<Hotel> getAllHotels();
public Optional<Hotel> getHotelById(String id);
public Hotel updateHotelById(String id,Hotel hotel);
}
