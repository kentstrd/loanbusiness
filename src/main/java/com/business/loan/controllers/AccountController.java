package com.business.loan.controllers;

import com.business.loan.models.Account;
import com.business.loan.models.AccountProfile;

import com.business.loan.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@ResponseBody
public class AccountController {
    private final AccountService service;

    public AccountController(
            AccountService service
    ) {
        this.service = service;
    }

    @PostMapping("/account")
    Account createAccount(@RequestBody Account account) {
        return this.service.create(account);
    }

    @GetMapping("/account/{id}")
    Optional<Account> getAccountById(@PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @GetMapping("/account")
    Collection<Account> getAccounts() {
        return this.service.findAll();
    }

    @PostMapping("/account/{id}")
    Account updateAccount(@PathVariable("id") Long id, @RequestBody AccountProfile updatedProfile) {
        return this.updateAccount(id, updatedProfile);
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable("id") Long id) {
        this.service.delete(id);
    }

}

