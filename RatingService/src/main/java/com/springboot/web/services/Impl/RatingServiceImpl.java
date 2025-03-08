package com.springboot.web.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.entities.Rating;
import com.springboot.web.repositories.RatingRepository;
import com.springboot.web.services.RatingService;
@Service
public class RatingServiceImpl implements RatingService{public RatingServiceImpl() {
	// TODO Auto-generated constructor stub
}@Autowired
private RatingRepository rRepo;
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		String randomId=UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return this.rRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		// TODO Auto-generated method stub
		return this.rRepo.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.rRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return this.rRepo.findByHotelId(hotelId);
	}

	@Override
	public Rating updateRatingById(String ratingId,Rating rating) {
		// TODO Auto-generated method stub
		return this.rRepo.save(rating);
	}
	
	

}
