package com.yangbofan.blog.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangbofan.blog.models.User;
import com.yangbofan.blog.repositories.UserRepository;

@Service
public class UserService{
	@Autowired 
    private UserRepository userRepository;
	
	public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
	public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(String username, String email, String phoneNumber, String password) {
		if (findByUsername(username) != null) return null;
		return userRepository.save(new User(username, email, phoneNumber, password));		
	}
}

