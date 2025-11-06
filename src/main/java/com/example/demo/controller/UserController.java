package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000") // ✅ Allow requests from React app
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Register user
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "User registered successfully!";
    }

    // ✅ Login user
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean success = userService.login(user.getUsername(), user.getPassword());
        return success ? "Login successful!" : "Invalid credentials!";
    }
}
