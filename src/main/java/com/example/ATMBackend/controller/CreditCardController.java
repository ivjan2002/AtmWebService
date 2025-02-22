package com.example.ATMBackend.controller;

import com.example.ATMBackend.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/validate-pin")
    public String validatePin(@RequestParam int cardId, @RequestParam String pin) {
        return creditCardService.validatePinAndGenerateToken(cardId, pin);
    }
}
