package com.business.loan.repositories;

import com.business.loan.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Collection<Loan> findByAccountId(Long accountId); // Find Loan by accountId
}

