package com.infinite.jsf.recipient.model;

import java.math.BigDecimal;
import java.util.Date;

import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public class Subscription {
    private String subscriptionId;
    private Recipient recipient; // FK: h_id
    private InsuranceCoverageOption coverage; // FK: coverage_id
    private java.util.Date subscribeDate;
    private java.util.Date expiryDate;
    private String status;
    private java.math.BigDecimal totalPremium;
    private java.math.BigDecimal amountPaid;
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
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
	public java.util.Date getSubscribeDate() {
		return subscribeDate;
	}
	public void setSubscribeDate(java.util.Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.math.BigDecimal getTotalPremium() {
		return totalPremium;
	}
	public void setTotalPremium(java.math.BigDecimal totalPremium) {
		this.totalPremium = totalPremium;
	}
	public java.math.BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(java.math.BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Subscription(String subscriptionId, Recipient recipient, InsuranceCoverageOption coverage,
			Date subscribeDate, Date expiryDate, String status, BigDecimal totalPremium, BigDecimal amountPaid) {
		super();
		this.subscriptionId = subscriptionId;
		this.recipient = recipient;
		this.coverage = coverage;
		this.subscribeDate = subscribeDate;
		this.expiryDate = expiryDate;
		this.status = status;
		this.totalPremium = totalPremium;
		this.amountPaid = amountPaid;
	}
	public Subscription() {
		super();
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", recipient=" + recipient + ", coverage=" + coverage
				+ ", subscribeDate=" + subscribeDate + ", expiryDate=" + expiryDate + ", status=" + status
				+ ", totalPremium=" + totalPremium + ", amountPaid=" + amountPaid + "]";
	}

    // Getters and Setters
    
    
    
    
}
