package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT a.balance FROM Account a")
    Double findBalance();
}
