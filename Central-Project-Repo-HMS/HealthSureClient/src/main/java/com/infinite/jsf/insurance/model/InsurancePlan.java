package com.infinite.jsf.insurance.model;

import java.io.Serializable;
import java.util.List;

public class InsurancePlan implements Serializable{

    private String planId;
    private InsuranceCompany insuranceCompany;
    private String planName;
    private String planDescription;
    private String planType;
    private String status;

    private List<InsuranceCoverageOption> coverageOptions;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InsuranceCoverageOption> getCoverageOptions() {
        return coverageOptions;
    }

    public void setCoverageOptions(List<InsuranceCoverageOption> coverageOptions) {
        this.coverageOptions = coverageOptions;
    }
}
