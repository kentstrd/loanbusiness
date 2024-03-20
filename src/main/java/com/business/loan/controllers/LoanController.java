package com.business.loan.controllers;


import com.business.loan.models.Loan;
import com.business.loan.models.ReqGrantLoan;
import com.business.loan.services.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@ResponseBody
public class LoanController {
    private final LoanService service;
    LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping("/loan")
    Collection<Loan> getLoans() {
        return this.service.findAll();
    }
    @GetMapping("/loan/{id}")
    Optional<Loan> getLoanBId(@PathVariable("id") Long id) {
        return this.service.findById(id);
    }
    @GetMapping("/loan/account/{id}")
    Collection<Loan> getLoanByAccountId(@PathVariable("id") Long id) {
        return this.service.findAllByAccountId(id);
    }
    @GetMapping("/loan/guarantor/{id}")
    Collection<Loan> findLoanByGuarantorId(@PathVariable("id") Long id) {
        return this.service.findLoanByGuarantorId(id);
    }
    @PostMapping("/loan")
    Loan createLoan(@RequestBody Loan loan) {
        return this.service.create(loan);
    }
    @PostMapping("/loan/{id}")
    Loan updateLoan(@PathVariable("id") Long id, @RequestBody Loan loan) {
        return this.service.update(id, loan);
    }
    @PostMapping("/loan/grant") Loan grantLoan(@RequestBody ReqGrantLoan body) {
        return this.service.grantLoan(body);
    }
    @DeleteMapping("/loan/{id}")
    void deleteLoan(@PathVariable("id") Long id) {
        this.service.delete(id);
    }


}
