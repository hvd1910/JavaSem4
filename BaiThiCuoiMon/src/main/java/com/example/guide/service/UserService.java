package com.example.guide.service;

import com.example.guide.DTO.UserLogin;
import com.example.guide.DTO.UserRegister;
import com.example.guide.entity.User;
import com.example.guide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public User login( UserLogin userLogin) throws Exception {
        User user = userRepository.findByUsername(userLogin.getUsername());

        if (user != null && user.getPassword().equals(userLogin.getPassword())) {
            return user;
        } else {
            throw new Exception("Invalid username or password");
        }
    }

    public User register( UserRegister userRegister) throws Exception {
        if (userRepository.findByUsername(userRegister.getUsername()) != null) {
            throw new Exception("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(userRegister.getUsername());
        newUser.setPassword(userRegister.getPassword());
        newUser.setRole(userRegister.getRole());
        return userRepository.save(newUser);
    }
}
