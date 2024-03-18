package com.business.loan.controllers;


import com.business.loan.models.Loan;
import com.business.loan.services.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@ResponseBody
public class LoanController {
    private final LoanService service;
    LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping("/loan")
    Loan createLoan(@RequestBody Loan loan) {
        return this.service.create(loan);
    }

    @GetMapping("/loan/{id}")
    Collection<Loan> getLoanByAccountId(@PathVariable("id") Long id) {
        return this.service.findAllByAccountId(id);
    }

    @GetMapping("/loan")
    Collection<Loan> getLoans() {
        return this.service.findAll();
    }

    @PostMapping("/loan/{id}")
    Loan updateLoan(@PathVariable("id") Long id, @RequestBody Loan loan) {
        return this.service.update(id, loan);
    }

    @DeleteMapping("/loan/{id}")
    void deleteLoan(@PathVariable("id") Long id) {
         this.service.delete(id);
    }

}
