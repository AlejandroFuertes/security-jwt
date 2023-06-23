package com.h2.h2api.service;

import com.h2.h2api.entity.User;

public interface UserService {

	User saveUser(User user);

	User getUser(Long idUser);

	User updateUser(Long idUser, User user);

	Boolean deleteUser(Long idUser);
}
