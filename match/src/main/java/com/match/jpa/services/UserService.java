package com.match.jpa.services;

import java.util.List;

import com.match.entities.User;

public interface UserService {
	User findOne(Long id);
	List<User> findAllUser();
	User createUser(User user);
	User updateUser(User user);
	User findUserByName(String name);
}
