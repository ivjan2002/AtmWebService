package com.example.ATMBackend.service;

import com.example.ATMBackend.model.CreditCard;
import com.example.ATMBackend.repository.CreditCardRepository;
import com.example.ATMBackend.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private JWTUtil jwtUtil;


    public String validatePinAndGenerateToken(int cardId, String enteredPin) {
        CreditCard card = creditCardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));


        if (enteredPin.length() == 4 && enteredPin.equals(card.getPin())) {
            return jwtUtil.generateToken(card.getAccount().getUser().getEmail());
        } else {
            throw new RuntimeException("Invalid PIN");
        }
    }
}
