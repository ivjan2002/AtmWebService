package com.example.ATMBackend.controller;

import com.example.ATMBackend.security.JwtUtils;
import com.example.ATMBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private JwtUtils jwtUtils;

    @Autowired
    public AccountController(AccountService accountService,JwtUtils jwtUtils){
        this.accountService=accountService;
        this.jwtUtils=jwtUtils;

    }

    @GetMapping("/balance")
    public ResponseEntity<?> getAmount(@RequestHeader("Authorization") String token, @RequestParam Integer accountId) {
        try {
            if (!jwtUtils.validateJwtToken(token.substring(7))) {
                return ResponseEntity.status(401).body("Invalid token");
            }

            Double balance = accountService.getBalancefromDataBase(accountId);
            return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Access denied");
        }
    }
    @PostMapping("/deposit")
    public String withdraw(@RequestParam Integer accountId, @RequestParam Double amount) {
        return accountService.withdrawAmount(accountId, amount);
    }

    @PostMapping("/withdraw")
    public String deposit(@RequestParam Integer accountId, @RequestParam Double amount) {
        return accountService.depositAmount(accountId, amount);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Integer fromAccountId, @RequestParam Integer toAccountId, @RequestParam Double amount) {
        return accountService.transferAmount(fromAccountId, toAccountId, amount);
    }

}
