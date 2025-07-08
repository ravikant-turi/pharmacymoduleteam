package com.infinite.jsf.provider.model;

public class Account {
    private Integer accountId;
    private Provider provider;
    private String bankName;
    private String ifscCode;
    private String accountNumber;

    // Constructors
    public Account() {
    }

    public Account(Integer accountId, Provider provider, String bankName, 
                 String ifscCode, String accountNumber) {
        this.accountId = accountId;
        this.provider = provider;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", provider=" + provider +
                ", bankName='" + bankName + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
