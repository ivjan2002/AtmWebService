package com.example.ATMBackend.service;

import com.example.ATMBackend.model.Transaction;
import com.example.ATMBackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {


    private TransactionRepository transactionRepo;

    @Autowired
    public TransactionService(TransactionRepository transactionRepo){
        this.transactionRepo=transactionRepo;

    }

    public List<Transaction> getAllTransactions(){
        return transactionRepo.findAll();
    }
}
