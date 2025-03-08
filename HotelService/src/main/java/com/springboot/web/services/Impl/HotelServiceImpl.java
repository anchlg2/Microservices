package com.springboot.web.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.entities.Hotel;
import com.springboot.web.repositories.HotelRepository;
import com.springboot.web.services.HotelService;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
private HotelRepository hRepo;
	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomId= UUID.randomUUID().toString();
		hotel.setId(randomId);
		return this.hRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return this.hRepo.findAll();
	}

	@Override
	public Optional<Hotel> getHotelById(String id) {
		// TODO Auto-generated method stub
		return this.hRepo.findById(id);
	}

	@Override
	public Hotel updateHotelById(String id,Hotel hotel) {
		// TODO Auto-generated method stub
		return this.hRepo.save(hotel);
	}

}
