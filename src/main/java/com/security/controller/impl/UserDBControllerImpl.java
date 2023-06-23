package com.security.controller.impl;

import com.security.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.controller.UserDBController;
import com.security.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "v1")
@RestController
public class UserDBControllerImpl implements UserDBController {

	private final UserServiceImpl userServiceImpl;

	@Override
	public ResponseEntity<User> createUserController(@RequestBody User user) {
		return new ResponseEntity<User>(userServiceImpl.saveUser(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<User> getUserController(@PathVariable(value = "id") Long idUser) {
		return new ResponseEntity<User>(userServiceImpl.getUser(idUser), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<User> updateUserController(@PathVariable(value = "id") Long idUser, @RequestBody User user) {
		return new ResponseEntity<User>(userServiceImpl.updateUser(idUser, user), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> deleteUserController(@PathVariable(value = "id") Long idUser) {
		Boolean response = userServiceImpl.deleteUser(idUser);
		if (response == true) {
			return new ResponseEntity<Long>(HttpStatus.OK);
		}
		return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
	}

}
