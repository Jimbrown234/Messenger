package com.brown.UserMs.service;

import com.brown.UserMs.dto.UserDTO;
import com.brown.UserMs.entity.User;
import com.brown.UserMs.repository.UserRepository;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepo;

	public UserDTO getUser(@PathVariable String email) {
		
		UserDTO userDTO = null;
		
		Optional<User> opUser = userRepo.findById(email);
		if(opUser.isPresent()) {
			
			User user = opUser.get();
			
			userDTO = UserDTO.valueOf(user);
		}
		return userDTO;
	}

}
