package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

}