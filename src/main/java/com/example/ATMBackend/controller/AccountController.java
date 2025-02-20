package com.example.ATMBackend.controller;

import com.example.ATMBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/deposit")
    public String withdraw(@RequestParam Integer accountId, @RequestParam Double amount) {
        return accountService.withdrawAmount(accountId, amount);
    }

    @PostMapping("/withdraw")
    public String deposit(@RequestParam Integer accountId, @RequestParam Double amount) {
        return accountService.depositAmount(accountId, amount);
    }

}
