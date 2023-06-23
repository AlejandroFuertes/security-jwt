package com.security.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.security.entity.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private static final String FAILURE_MESSAGE = "User not found";

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long idUser) {
		return userRepository.findById(idUser)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, FAILURE_MESSAGE));
	}

	@Override
	public User updateUser(Long idUser, User user) {
		User userEdit = userRepository.findById(idUser)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, FAILURE_MESSAGE));

		userEdit.setName(user.getName());
		userEdit.setLastname(user.getLastname());
		userEdit.setPhoneNumber(user.getPhoneNumber());
		userEdit.setAddress(user.getAddress());

		return userRepository.save(userEdit);
	}

	@Override
	public Boolean deleteUser(Long idUser) {

		try {
			userRepository.deleteById(idUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
