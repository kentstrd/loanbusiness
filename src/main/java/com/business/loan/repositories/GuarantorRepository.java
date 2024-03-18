package com.business.loan.repositories;

import com.business.loan.models.Guarantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarantorRepository extends JpaRepository<Guarantor, Long> { }
