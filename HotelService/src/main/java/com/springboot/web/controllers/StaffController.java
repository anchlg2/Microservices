package com.springboot.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@GetMapping
public List<String> getStaff()
{
	List<String> list=List.of("Anchal","Tia","Tara","Riya");
	return list;
}
}
