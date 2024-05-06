package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getPasswordByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getPassword();
        } else {
            return null; // Return null if username not found
        }
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
}