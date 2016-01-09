package com.match.jpa.services;

import java.util.List;

import com.match.entities.User;

public interface UserService {
	User findOne(Long id);
	List<User> findAll();
	User create(User user);
	User update(User user);
	User findUserByName(String name);
}
