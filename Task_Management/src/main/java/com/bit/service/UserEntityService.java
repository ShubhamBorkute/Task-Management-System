package com.bit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.entity.UserEntity;
import com.bit.repository.UserRepository;

@Service
public class UserEntityService {
    
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);

	}
}
