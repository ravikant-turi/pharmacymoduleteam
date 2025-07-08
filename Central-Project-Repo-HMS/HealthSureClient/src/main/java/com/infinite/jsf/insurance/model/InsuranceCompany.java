package com.infinite.jsf.insurance.model;

import java.io.Serializable;
import java.util.Set;

public class InsuranceCompany implements Serializable{

    private String companyId;
    private String companyName;
    private String contactEmail;
    private String contactNumber;
    private String address;

    // One-to-Many Relationship: One company has many plans
    private Set<InsurancePlan> insurancePlans;

    // Getters and Setters
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<InsurancePlan> getInsurancePlans() {
        return insurancePlans;
    }

    public void setInsurancePlans(Set<InsurancePlan> insurancePlans) {
        this.insurancePlans = insurancePlans;
    }
}
