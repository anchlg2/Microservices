package com.springboot.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.Hotel;
import com.springboot.web.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hService;
	
	// create hotel
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
	{
		Hotel hotel2=this.hService.addHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
		
	}
	//get all hotels
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		List<Hotel> hotels=this.hService.getAllHotels();
		return ResponseEntity.ok(hotels);
	}
	//get hotel by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Hotel>> getHotelById(@PathVariable("id") String id)
	{
		Optional<Hotel> hotel2=this.hService.getHotelById(id);
		return ResponseEntity.ok(hotel2);
		
	}
	//update hotel by id
	@PutMapping("{id}")
	public ResponseEntity<Hotel> updateHotelById(@PathVariable("id") String id,@RequestBody Hotel hotel)
	{
		Hotel hotel2=this.hService.updateHotelById(id, hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
		
	}

}
