package com.infinite.jsf.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.common.eventbus.Subscribe;
import com.infinite.jsf.recipient.model.Recipient;

public class Claims implements Serializable{

    private String claimId;

    private Subscribe coverage;               // Changed from String coverageId → Subscribe object

    private MedicalProcedure procedure;              // Refers to medical_procedure

    private Provider provider;                // Refers to Providers

    private Recipient recipient;              // Refers to Recipient

    private String claimStatus;

    private Date claimDate;

    private BigDecimal amountClaimed;

    private BigDecimal amountApproved;

    private List<ClaimHistory> claimHistories;  // One-to-many relationship

    // Getters and Setters

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Subscribe getCoverage() {
        return coverage;
    }

    public void setCoverage(Subscribe coverage) {
        this.coverage = coverage;
    }

    public MedicalProcedure getProcedure() {
        return procedure;
    }

    public void setProcedure(MedicalProcedure procedure) {
        this.procedure = procedure;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public BigDecimal getAmountClaimed() {
        return amountClaimed;
    }

    public void setAmountClaimed(BigDecimal amountClaimed) {
        this.amountClaimed = amountClaimed;
    }

    public BigDecimal getAmountApproved() {
        return amountApproved;
    }

    public void setAmountApproved(BigDecimal amountApproved) {
        this.amountApproved = amountApproved;
    }

    public List<ClaimHistory> getClaimHistories() {
        return claimHistories;
    }

    public void setClaimHistories(List<ClaimHistory> claimHistories) {
        this.claimHistories = claimHistories;
    }
}
