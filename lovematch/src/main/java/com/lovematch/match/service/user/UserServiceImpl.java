package com.lovematch.match.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.User;
import com.lovematch.match.jpa.repository.UserRepository;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User findByNameAndPwd(String name ,String pwd) {
		
		return userRepository.findUserByNameAndPsw(name, pwd);
	}
	@Override
	public User find(Long id) {
		return userRepository.findOne(id);
	}
	@Override
	public User create(User entity) {
		return userRepository.save(entity);
	}
	@Override
	public User update(User entity) {
		return userRepository.saveAndFlush(entity);
	}
	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
	@Override
	public User findByName(String name) {
		return userRepository.findUserByName(name);
	}

}
