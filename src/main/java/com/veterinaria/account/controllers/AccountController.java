package com.veterinaria.account.controllers;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.veterinaria.account.models.Account;
import com.veterinaria.account.repositories.AccountRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{username}")
    Account getAccount(@PathVariable String username) throws AccountNotFoundException {
        return accountRepository.findById(username)
                .orElseThrow(() -> new AccountNotFoundException("Usuario no encontrado: " + username));
    }

    @PostMapping("/account")
    Account newAccount(@RequestBody Account account) {
        account.setLastChange(new Date());
        return accountRepository.save(account);
    }

    @GetMapping("/account")
    List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @DeleteMapping("/account")
    void deleteAccount(@PathVariable String idUsuario) {

    }
}
