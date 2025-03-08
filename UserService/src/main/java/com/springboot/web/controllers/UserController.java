package com.springboot.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.User;
import com.springboot.web.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService uService;
//1 add user
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
	User user2= this.uService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	//get all users
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers()
	{
	List<User> users= this.uService.getAllUsers();
	return ResponseEntity.ok(users);
	}
	//get user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id)
	{
	User user= this.uService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	//update user by id
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") String id,@RequestBody User user)
	{
	User user2= this.uService.updateUserById(id,user);
	return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
}
