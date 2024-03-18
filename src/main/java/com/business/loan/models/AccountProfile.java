package com.business.loan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class AccountProfile  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String phone;
    private String address;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;
    public void setAccount(Account account) { this.account = account;}
    public String getFullName() { return fullName;}
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
