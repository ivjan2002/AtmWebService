package com.example.ATMBackend.controller;

import com.example.ATMBackend.model.Transaction;
import com.example.ATMBackend.security.JwtUtils;
import com.example.ATMBackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transService;
    private JwtUtils jwtUtils;

    @Autowired
    public TransactionController(TransactionService transService,JwtUtils jwtUtils){
        this.transService=transService;
        this.jwtUtils=jwtUtils;
    }

    @GetMapping
    public ResponseEntity<?> getALL(@RequestHeader("Authorization") String token) {
        try {

            if (!jwtUtils.validateJwtToken(token.substring(7))) {
                return ResponseEntity.status(401).body("Invalid token");
            }

            List<Transaction> transactions = transService.getAllTransactions();
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Access denied");
        }
    }

}
