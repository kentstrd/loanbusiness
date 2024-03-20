package com.business.loan.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "guarantors")
public class Guarantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String phone;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "loan_guarantors",
            joinColumns = @JoinColumn(name = "guarantor_id"),
            inverseJoinColumns = @JoinColumn(name = "loan_id")
    )
    @JsonIgnore()
    private Collection<Loan> loans;
    public Collection<Loan> getLoans() {
        return loans;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public Long getId() {
        return id;
    }
}
