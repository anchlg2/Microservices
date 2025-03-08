package com.springboot.web.repositories;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {
	//write custom methods in here
	

}
