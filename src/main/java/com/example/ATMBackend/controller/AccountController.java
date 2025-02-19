package com.example.ATMBackend.controller;

import com.example.ATMBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;

    }

    @GetMapping("/balance")
    public Double getAmount(){
        return accountService.getBalancefromDataBase();
    }

}
