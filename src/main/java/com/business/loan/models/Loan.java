package com.business.loan.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "loan_amount")
    private Float loanAmount;
    @Column(name = "interest_rate")
    private Float interestRate;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    public Account getAccount() {
        return account;
    }
    public Float getLoanAmount() {
        return loanAmount;
    }
    public Float getInterestRate() {
        return interestRate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getStatus() {
        return status;
    }
}

