package com.infinite.jsf.admin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.infinite.jsf.provider.model.Provider;
import com.infinite.jsf.recipient.model.Recipient;

public class PaymentHistory implements Serializable{
    private int paymentId;
    private Recipient recipient;   // mapped by h_id
    private Provider provider;     // mapped by provider_id
    private BigDecimal amount;
    private String paymentMethod;
    private String paymentStatus;
    public PaymentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Date paymentDate;
    private String remarks;

    // Getters and Setters

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
