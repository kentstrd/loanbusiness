package com.business.loan.repositories;

import com.business.loan.models.Guarantor;
import com.business.loan.models.Loan;
import org.hibernate.boot.model.source.spi.AttributePath;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByGuarantors_Id(Long guarantorId);
    Collection<Loan> findByAccountId(Long accountId); // Find Loan by accountId
}

