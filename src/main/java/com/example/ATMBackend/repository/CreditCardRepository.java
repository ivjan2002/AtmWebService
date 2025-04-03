package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    Optional<CreditCard> findByPin(String pin);

}