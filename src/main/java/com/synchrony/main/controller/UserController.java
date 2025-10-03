package com.synchrony.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synchrony.main.entities.User;
import com.synchrony.main.model.UserDto;
import com.synchrony.main.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
    private UserServiceImpl service;

    @GetMapping("/profile/{username}")
    public ResponseEntity<User> getProfile(@PathVariable("username") String username) {
        User registeredUser = service.findUserByUserName(username);
        if (registeredUser == null) {
            return ResponseEntity.notFound().build();
        }
      
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User registeredUser = service.saveUser(user);
        return ResponseEntity.ok("User registered successfully with username: " 
                                  + registeredUser.getUsername());
    }
	
}
