package com.example.ATMBackend.controller;

import com.example.ATMBackend.model.Transaction;
import com.example.ATMBackend.service.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class transactionController {

    private transactionService transService;

    @Autowired
    public transactionController( transactionService transService){
        this.transService=transService;
    }

    @GetMapping
    public List<Transaction> getALL(){
        return transService.getAllTransactions();

    }
}
