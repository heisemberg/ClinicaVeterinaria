package com.veterinaria.account.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/account/{id}")
    Account getAccount(@PathVariable String id) throws AccountNotFoundException {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Id de usuario no encontrado: " + id));
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
    Map<String, String> deleteAccount(@PathVariable String idUsuario) {
        HashMap<String, String> res = new HashMap<String, String>();
        Optional<Account> exist = accountRepository.findById(idUsuario);
        if (exist.isPresent()) {
            res.put("message", "borrado satisfactoriamente");
            accountRepository.deleteById(idUsuario);
            return res;
        }
        res.put("message", "usuario no existe");
        return res;
    }

    @PutMapping("/account/{id}")
    Map<String, String> updateAccount(@PathVariable String idUsuario) {
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "actualizado satisfactoriamente");
        return res;
    }
}
