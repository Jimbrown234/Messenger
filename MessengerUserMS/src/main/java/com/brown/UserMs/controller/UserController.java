package com.brown.UserMs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.brown.UserMs.dto.UserDTO;
import com.brown.UserMs.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getUser(@PathVariable String email) {
		
		return userService.getUser(email);
	}
	
}
