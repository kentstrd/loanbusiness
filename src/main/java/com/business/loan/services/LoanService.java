package com.business.loan.services;

import com.business.loan.models.Account;
import com.business.loan.models.Guarantor;
import com.business.loan.models.Loan;
import com.business.loan.models.ReqGrantLoan;
import com.business.loan.repositories.AccountRepository;
import com.business.loan.repositories.GuarantorRepository;
import com.business.loan.repositories.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private GuarantorRepository guarantorRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Loan create(Loan data) {
        Account account = this.accountRepository.findById(data.getAccountId()).orElse(null);

        if (account != null) {
            data.setAccount(account);
            return this.loanRepository.save(data);
        }
        throw new IllegalArgumentException("Invalid account ID");
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

    public Collection<Loan> findLoanByGuarantorId(Long id) {
        return this.loanRepository.findByGuarantors_Id(id);
    }

    public Loan update(Long id, Loan updatedLoan) {
        // Retrieve the existing account
        Loan savedLoan = this.loanRepository.findById(id).orElse(null);
        if (savedLoan != null) {
            savedLoan.setLoanAmount(updatedLoan.getLoanAmount());
            savedLoan.setInterestRate(updatedLoan.getInterestRate());
            savedLoan.setEndDate(updatedLoan.getEndDate());
            savedLoan.setStartDate(updatedLoan.getStartDate());
            savedLoan.setStatus(updatedLoan.getStatus());
            return this.loanRepository.save(savedLoan);
        }
        return updatedLoan;
    }

    public void delete(Long id) {
            this.loanRepository.deleteById(id);
    }


    @Transactional
    public Loan grantLoan(ReqGrantLoan body) {

        Guarantor guarantor = this.guarantorRepository.findById(body.getGuarantorId()).orElse(null);

        if (guarantor == null) {
            throw new IllegalArgumentException("Invalid Guarantor ID");
        }

        Loan loan = this.loanRepository.findById(body.getLoanId()).orElse(null);

        if (loan == null) {
            throw new IllegalArgumentException("Invalid Loan ID");
        }

        guarantor.getLoans().add(loan);
        loan.getGuarantors().add(guarantor);

        this.guarantorRepository.save(guarantor);

        return this.loanRepository.save(loan);

    }

}
