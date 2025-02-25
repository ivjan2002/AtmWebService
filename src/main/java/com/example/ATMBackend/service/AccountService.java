package com.example.ATMBackend.service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public String depositAmount(Integer accountId, Double amount) {
        Double currentBalance = getBalancefromDataBase();

        if (currentBalance < amount) {
            return "Nedovoljno sredstava na računu!";
        }

        int updatedRows = accountRepository.deposit(accountId, amount);
        return updatedRows > 0 ? "Isplata uspešna!" : "Greška pri isplati.";
    }

    @Transactional
    public String withdrawAmount(Integer accountId, Double amount) {
        if (amount <= 0) {
            return "Iznos mora biti veći od 0!";
        }

        int updatedRows = accountRepository.withdraw(accountId, amount);
        return updatedRows > 0 ? "Uplata uspešna!" : "Greška pri uplati.";
    }

}
