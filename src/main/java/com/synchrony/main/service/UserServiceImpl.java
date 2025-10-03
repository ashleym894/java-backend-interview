package com.synchrony.main.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synchrony.main.entities.User;
import com.synchrony.main.model.UserDto;
import com.synchrony.main.repositories.UserRepository;

@Service
public class UserServiceImpl {
	
	private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User newUser) {
    	newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

	public User findUserByUserName(String username) {
		return userRepository.findByUsername(username)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	}
}
