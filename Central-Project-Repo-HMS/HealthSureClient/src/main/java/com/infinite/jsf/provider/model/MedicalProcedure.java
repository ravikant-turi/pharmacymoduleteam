package com.infinite.jsf.provider.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.infinite.jsf.recipient.model.Recipient;
public class MedicalProcedure implements Serializable{

    private String procedureId;
    private Appointment appointment; // Added as object
    private Recipient recipient;
    private Provider provider;
    private Doctor doctor;
    private Date procedureDate;
    private String diagnosis;
    private String recommendations;
    private Date fromDate;
    private Date toDate;
    private Date createdAt;
    private Set<Claims> claims;
    private Set<ProcedureTest> tests;
    private Set<Prescription> prescriptions;
    // Getters and Setters
    public String getProcedureId() {
        return procedureId;
    }
    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Claims> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claims> claims) {
        this.claims = claims;
    }

    public Set<ProcedureTest> getTests() {
        return tests;
    }

    public void setTests(Set<ProcedureTest> tests) {
        this.tests = tests;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
