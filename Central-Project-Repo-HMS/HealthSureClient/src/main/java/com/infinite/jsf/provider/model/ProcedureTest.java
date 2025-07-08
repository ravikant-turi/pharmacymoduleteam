package com.infinite.jsf.provider.model;

import java.io.Serializable;
import java.util.Date;

public class ProcedureTest implements Serializable{
    private String testId;
    private MedicalProcedure procedure;
    private String testName;
    private Date testDate;
    private String resultSummary;
    private String status;
    private Date createdAt;

    // Getters and Setters
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public MedicalProcedure getProcedure() {
        return procedure;
    }

    public void setProcedure(MedicalProcedure procedure) {
        this.procedure = procedure;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    public void setResultSummary(String resultSummary) {
        this.resultSummary = resultSummary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
