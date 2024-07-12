package com.example.guide.controller;

import com.example.guide.DTO.UserLogin;
import com.example.guide.DTO.UserRegister;
import com.example.guide.entity.User;
import com.example.guide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody UserLogin userLogin) {
        try {
            User user = userService.login(userLogin);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register( @RequestBody UserRegister userRegister) {
        try {
            User user = userService.register(userRegister);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
