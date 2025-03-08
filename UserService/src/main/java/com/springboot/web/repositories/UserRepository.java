package com.springboot.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
//to create custom methods here
	public User findByuserId(String userId);
}
