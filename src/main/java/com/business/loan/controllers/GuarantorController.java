package com.business.loan.controllers;

import com.business.loan.models.Account;
import com.business.loan.models.Guarantor;
import com.business.loan.services.GuarantorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@ResponseBody
public class GuarantorController {
    private final GuarantorService service;
    GuarantorController(GuarantorService service) {
        this.service = service;
    }

    @GetMapping("/guarantor")
    Collection<Guarantor> getGuarantors() {
        return this.service.findAll();
    }

    @GetMapping("/guarantor/{id}")
    Optional<Guarantor> guarantors (@PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @GetMapping("/guarantor/loan/{id}")
    Collection<Guarantor> findGuarantorByLoanId(@PathVariable("id") Long id) {
        return this.service.findGuarantorsByLoanId(id);
    }

    @PostMapping("/guarantor")
    Guarantor createGuarantor(@RequestBody Guarantor guarantor) {
        return this.service.create(guarantor);
    }

}
