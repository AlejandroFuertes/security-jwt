package com.h2.h2api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.h2api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
