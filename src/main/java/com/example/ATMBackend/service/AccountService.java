package com.example.ATMBackend.service;

import com.example.ATMBackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public Double getBalancefromDataBase(){
        return accountRepository.findBalance();
    }

}
