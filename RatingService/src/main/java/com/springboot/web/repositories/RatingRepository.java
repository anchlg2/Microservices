package com.springboot.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
//write custom methods here
	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);
	
}
