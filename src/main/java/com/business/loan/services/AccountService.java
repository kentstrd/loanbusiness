package com.business.loan.services;

import com.business.loan.models.Account;
import com.business.loan.models.AccountProfile;
import com.business.loan.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account create(Account account) {
        return this.accountRepository.save(account);
    }

    public Optional<Account> findById(Long id) {
        return this.accountRepository.findById(id);
    }

    public Collection<Account> findAll() {
        return this.accountRepository.findAll();
    }

    public Account update(Long id, AccountProfile updatedProfile) {
        // Retrieve the existing account
        Account savedAccount = this.accountRepository.findById(id).orElse(null);
        if (savedAccount != null) {
            // Update the profile
            savedAccount.getProfile().setFullName(updatedProfile.getFullName());
            savedAccount.getProfile().setPhone(updatedProfile.getPhone());
            savedAccount.getProfile().setAddress(updatedProfile.getAddress());

            this.accountRepository.save(savedAccount);
        }

        return savedAccount;
    }

    public void delete(Long id) {
        this.accountRepository.deleteById(id);
    }

}
