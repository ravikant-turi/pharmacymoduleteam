package com.infinite.jsf.provider.model;

import java.util.Date;

public class PrescribedMedicines {
private String prescribedId;
private Prescription prescription;
private String medicineName;
private String dosage;
private String duration;
private String notes;
private Date createdAt;
public String getPrescribedId() {
	return prescribedId;
}
public void setPrescribedId(String prescribedId) {
	this.prescribedId = prescribedId;
}
public Prescription getPrescription() {
	return prescription;
}
public void setPrescription(Prescription prescription) {
	this.prescription = prescription;
}
public String getMedicineName() {
	return medicineName;
}
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}
public String getDosage() {
	return dosage;
}
public void setDosage(String dosage) {
	this.dosage = dosage;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public PrescribedMedicines(String prescribedId, Prescription prescription, String medicineName, String dosage,
		String duration, String notes, Date createdAt) {
	super();
	this.prescribedId = prescribedId;
	this.prescription = prescription;
	this.medicineName = medicineName;
	this.dosage = dosage;
	this.duration = duration;
	this.notes = notes;
	this.createdAt = createdAt;
}
public PrescribedMedicines() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "PrescribedMedicines [prescribedId=" + prescribedId + ", prescription=" + prescription + ", medicineName="
			+ medicineName + ", dosage=" + dosage + ", duration=" + duration + ", notes=" + notes + ", createdAt="
			+ createdAt + "]";
}

}
