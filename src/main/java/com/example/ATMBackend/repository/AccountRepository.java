package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT a.balance FROM Account a")
    Double findBalance();

    @Modifying
    @Query("UPDATE Account a SET a.balance = a.balance - :amount WHERE a.id = :accountId AND a.balance >= :amount")
    int deposit(@Param("accountId") Integer accountId, @Param("amount") Double amount);

    @Modifying
    @Query("UPDATE Account a SET a.balance = a.balance + :amount WHERE a.id = :accountId")
    int withdraw(@Param("accountId") Integer accountId, @Param("amount") Double amount);

}
