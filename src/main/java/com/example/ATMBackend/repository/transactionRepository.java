package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepository extends JpaRepository<Transaction,Integer> {
}
