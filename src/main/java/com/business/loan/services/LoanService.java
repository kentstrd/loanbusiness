package com.business.loan.services;

import com.business.loan.models.Account;
import com.business.loan.models.AccountProfile;
import com.business.loan.models.Loan;
import com.business.loan.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    public Loan create(Loan data) {
        return this.loanRepository.save(data);
    }

    public Optional<Loan> findById(Long id) {
        return this.loanRepository.findById(id);
    }

    public Collection<Loan> findAll() {
        return this.loanRepository.findAll();
    }

    public Collection<Loan> findAllByAccountId(Long id) {
        return this.loanRepository.findByAccountId(id);
    }

    public Loan update(Long id, Loan updatedLoan) {
        // Retrieve the existing account
        Loan savedLoan = this.loanRepository.findById(id).orElse(null);
        if (savedLoan != null) {
            this.loanRepository.save(updatedLoan);
        }
        return updatedLoan;
    }

    public void delete(Long id) {
            this.loanRepository.deleteById(id);
    }

}
