package com.sakinramzan.blogapp.service.impl;


import com.sakinramzan.blogapp.entity.User;
import com.sakinramzan.blogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    public void save(User user) {
//        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

