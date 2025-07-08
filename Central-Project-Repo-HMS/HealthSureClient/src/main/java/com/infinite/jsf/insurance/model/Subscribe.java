package com.infinite.jsf.insurance.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import com.infinite.jsf.provider.model.Claims;
import com.infinite.jsf.recipient.model.Recipient;

public class Subscribe {
    private String subscribeId;
    private Recipient recipient;
    private InsuranceCoverageOption coverage;
    private Date subscribeDate;
    private Date expiryDate;
    private SubscriptionType type;
    private SubscriptionStatus status;
    private double totalPremium;
    private BigDecimal amountPaid;
    
    // One-to-Many relationships
    private Set<SubscribedMember> members;
    private Set<Claims> claims;

    // Constructors
    public Subscribe() {}

    public Subscribe(String subscribeId, Recipient recipient, 
                   InsuranceCoverageOption coverage, Date subscribeDate,
                   Date expiryDate, SubscriptionType type) {
        this.subscribeId = subscribeId;
        this.recipient = recipient;
        this.coverage = coverage;
        this.subscribeDate = subscribeDate;
        this.expiryDate = expiryDate;
        this.type = type;
        this.status = SubscriptionStatus.ACTIVE;
        this.totalPremium = coverage.getPremiumAmount();
        this.amountPaid = BigDecimal.ZERO;
    }

    // Getters and Setters
    public String getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public InsuranceCoverageOption getCoverage() {
        return coverage;
    }

    public void setCoverage(InsuranceCoverageOption coverage) {
        this.coverage = coverage;
    }

    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Set<SubscribedMember> getMembers() {
        return members;
    }

    public void setMembers(Set<SubscribedMember> members) {
        this.members = members;
    }

    public Set<Claims> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claims> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
               "subscribeId='" + subscribeId + '\'' +
               ", recipient=" + recipient.gethId() +
               ", coverage=" + coverage.getCoverageId() +
               ", subscribeDate=" + subscribeDate +
               ", expiryDate=" + expiryDate +
               ", type=" + type +
               ", status=" + status +
               ", totalPremium=" + totalPremium +
               ", amountPaid=" + amountPaid +
               '}';
    }
}