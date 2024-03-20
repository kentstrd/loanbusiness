package com.business.loan.services;

import com.business.loan.models.Account;
import com.business.loan.models.Guarantor;
import com.business.loan.repositories.GuarantorRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GuarantorService {
    @Autowired
    private GuarantorRepository guarantorRepository;
    public Collection<Guarantor> findAll() {
        return this.guarantorRepository.findAll();
    }
    public Guarantor create(Guarantor data) {
        return this.guarantorRepository.save(data);
    }
    public Optional<Guarantor> findById(Long id) {
        return this.guarantorRepository.findById(id);
    }
    public Collection<Guarantor> findGuarantorsByLoanId(Long id) {
        return this.guarantorRepository.findByLoans_Id(id);
    }

}
