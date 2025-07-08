package com.infinite.jsf.provider.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.infinite.jsf.recipient.model.Recipient;

public class Prescription implements Serializable{

    private String prescriptionId;

    // Foreign key object mappings
    private MedicalProcedure procedure;    // mapped from procedure_id
    private Recipient recipient;           // mapped from h_id
    private Provider provider;             // mapped from provider_id
    private Doctor doctor;                 // mapped from doctor_id

    // Other fields
    private Timestamp writtenOn;
    private Timestamp createdAt;
    private List<PrescribedMedicines> prescribedMedicines;
    // Getters and Setters
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public MedicalProcedure getProcedure() {
        return procedure;
    }

    public void setProcedure(MedicalProcedure procedure) {
        this.procedure = procedure;
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

    public Timestamp getWrittenOn() {
        return writtenOn;
    }

    public void setWrittenOn(Timestamp writtenOn) {
        this.writtenOn = writtenOn;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
