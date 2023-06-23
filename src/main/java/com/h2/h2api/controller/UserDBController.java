package com.h2.h2api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.h2.h2api.entity.User;

public interface UserDBController {

	@PostMapping(path = "/user")
	ResponseEntity<User> createUserController(User user);
	
	@GetMapping(path = "/user/{id}")
	ResponseEntity<User> getUserController(Long idUser);
	
	@PutMapping(path = "/user/{id}")
	ResponseEntity<User> updateUserController(Long idUser, User user);
	
	@DeleteMapping(path = "/user/{id}")
	ResponseEntity<Long> deleteUserController(Long idUser);
}
