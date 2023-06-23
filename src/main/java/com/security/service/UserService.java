package com.security.service;

import com.security.entity.User;

public interface UserService {

	User saveUser(User user);

	User getUser(Long idUser);

	User updateUser(Long idUser, User user);

	Boolean deleteUser(Long idUser);
}
