package com.example.ATMBackend.service;

import com.example.ATMBackend.model.User;
import com.example.ATMBackend.model.CreditCard;
import com.example.ATMBackend.repository.UserRepository;
import com.example.ATMBackend.repository.CreditCardRepository;
import com.example.ATMBackend.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public String login(String username, String pin) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CreditCard creditCard = creditCardRepository.findByPin(pin)
                .orElseThrow(() -> new RuntimeException("Invalid PIN"));

        if (!creditCard.getAccount().getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Invalid PIN for the user");
        }

        return jwtUtils.generateToken(username);
    }
}
