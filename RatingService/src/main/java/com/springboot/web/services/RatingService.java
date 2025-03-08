package com.springboot.web.services;

import java.util.List;

import com.springboot.web.entities.Rating;

public interface RatingService {
//create rating 
	public Rating createRating(Rating rating);
	//get all ratings
	public List<Rating> getAllRatings();
	//get all ratings given by particular userid
	public List<Rating> getRatingsByUserId(String userId);
	//get all ratings of particular hotel
		public List<Rating> getRatingsByHotelId(String hotelId);
	//update rating by rating id
		public Rating updateRatingById(String ratingId,Rating rating);
}
