package com.business.loan.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(name = "created_at")
    @CreationTimestamp
    @CreatedDate
    private Timestamp createdAt;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccountProfile profile;
    public Long getId() {
        return id;
    }
    public void setProfile(AccountProfile profile) {
        this.profile = profile;
        this.profile.setAccount(this);
    }
    public AccountProfile getProfile() {
        return profile;
    }
    public String getEmail() {
        return email;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
