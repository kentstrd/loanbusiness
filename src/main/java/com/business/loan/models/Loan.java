package com.business.loan.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @ManyToOne()
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;
    @ManyToMany(mappedBy = "loans", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            scope = Loan.class)
    protected Collection<Guarantor> guarantors;

    public Collection<Guarantor> getGuarantors() {
        return guarantors;
    }
    public Long getId() {
        return id;
    }
    public Long getAccountId() {
        return accountId;
    }
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

    public void setGuarantors(Collection<Guarantor> guarantors) {
        this.guarantors = guarantors;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLoanAmount(Float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

