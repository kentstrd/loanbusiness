package com.business.loan.models;

public class ReqGrantLoan {
    private Long loanId;
    private Long guarantorId;
    public Long getGuarantorId() {
        return guarantorId;
    }
    public Long getLoanId() {
        return loanId;
    }
}
