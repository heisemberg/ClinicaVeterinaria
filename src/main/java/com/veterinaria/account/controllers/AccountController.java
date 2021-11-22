package com.veterinaria.account.controllers;

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
        return accountRepository.findById(username).orElseThrow(
                () -> new AccountNotFoundException("No se encontro una cuenta con el username: " + username));
    }

    @PostMapping("/account")
    Account newAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}
