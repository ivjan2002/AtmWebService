package com.example.ATMBackend.service;

import com.example.ATMBackend.model.User;
import com.example.ATMBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User getUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

}
