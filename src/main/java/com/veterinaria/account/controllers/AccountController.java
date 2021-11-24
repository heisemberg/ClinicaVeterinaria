package com.veterinaria.account.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import com.veterinaria.account.models.Account;
import com.veterinaria.account.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    @Autowired
    private MongoOperations mongoOperations;

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

    @DeleteMapping("/account/{id}")
    Map<String, String> deleteAccount(@PathVariable String id) {
        HashMap<String, String> res = new HashMap<String, String>();
        Optional<Account> exist = accountRepository.findById(id);
        if (exist.isPresent()) {
            res.put("message", "borrado satisfactoriamente");
            accountRepository.deleteById(id);
            return res;
        }
        res.put("message", "usuario no existe");
        return res;
    }

    @PutMapping("/account/{id}")
    Map<String, String> updateAccount(@PathVariable String id, @RequestBody Account account) {
        HashMap<String, String> res = new HashMap<String, String>();
        Query query = new Query();

        query.addCriteria(Criteria.where("idUsuario").is(id));
        Account accountFounded = mongoOperations.findOne(query, Account.class);
        if (!account.getFirstName().equals("")) {
            accountFounded.setFirstName(account.getFirstName());
        }
        if (!account.getLastName().equals("")) {
            accountFounded.setLastName(account.getLastName());
        }
        if (!account.getTelefono().equals("")) {
            accountFounded.setTelefono(account.getTelefono());
        }
        if (!account.getCorreo().equals("")) {
            accountFounded.setCorreo(account.getCorreo());
        }
        accountRepository.save(accountFounded);

        res.put("message", "actualizado satisfactoriamente");
        return res;
    }
}
