package com.business.loan.controllers;

import com.business.loan.models.Guarantor;
import com.business.loan.repositories.GuarantorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
@Controller
@ResponseBody
public class GuarantorController {
    private final GuarantorRepository repository;
    GuarantorController(GuarantorRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/guarantors")
    Collection<Guarantor> guarantors () {
        return this.repository.findAll();
    }
}
