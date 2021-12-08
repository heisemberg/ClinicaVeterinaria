package com.veterinaria.account.repositories;

import com.veterinaria.account.models.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
