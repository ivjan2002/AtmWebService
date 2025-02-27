package com.example.ATMBackend.controller;

import com.example.ATMBackend.model.User;
import com.example.ATMBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/auth/register")
    public User registerUser(@RequestBody User user){
        return userService.getUser(user);
    }
}
