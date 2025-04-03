package com.example.ATMBackend.controller;

import com.example.ATMBackend.model.LoginRequest;
import com.example.ATMBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {

            String token = authService.login(loginRequest.getUsername(), loginRequest.getPin());
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {

            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
