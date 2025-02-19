package com.example.ATMBackend.service;

import com.example.ATMBackend.model.Transaction;
import com.example.ATMBackend.repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transactionService {


    private transactionRepository transactionRepo;

    @Autowired
    public transactionService(transactionRepository transactionRepo){
        this.transactionRepo=transactionRepo;

    }

    public List<Transaction> getAllTransactions(){
        return transactionRepo.findAll();
    }
}
