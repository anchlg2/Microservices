package com.springboot.web.controllers;

import java.util.List;

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

import com.springboot.web.entities.Rating;
import com.springboot.web.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService rService;
	//add rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		Rating rating2=this.rService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
	}
	// get all ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		List<Rating> ratings=this.rService.getAllRatings();
		return ResponseEntity.ok(ratings);
	}
	//get ratings by userid
	@GetMapping("/users/{userid}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable("userid") String userId)
	{
		List<Rating> ratings=this.rService.getRatingsByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	//get ratings by hotelid
		@GetMapping("/hotels/{hotelid}")
		public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable("hotelid") String hotelId)
		{
			List<Rating> ratings=this.rService.getRatingsByHotelId(hotelId);
			return ResponseEntity.ok(ratings);
		}
		//update rating by id
		@PutMapping("/{ratingId}")
		public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId,@RequestBody Rating rating)
		{
			Rating rating2=this.rService.updateRatingById(ratingId,rating);
			return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
		}
}

