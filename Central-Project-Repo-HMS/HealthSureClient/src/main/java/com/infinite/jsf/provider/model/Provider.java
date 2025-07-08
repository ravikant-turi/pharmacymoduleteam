package com.infinite.jsf.provider.model;

import java.sql.Timestamp;
import java.util.Set;




public class Provider {
    private String providerId;
    private String providerName;
    private String hospitalName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private ProviderStatus status;
    private Timestamp createdAt;
    
    public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public ProviderStatus getStatus() {
		return status;
	}
	public void setStatus(ProviderStatus status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Set<MedicalProcedure> getProcedures() {
		return procedures;
	}
	public void setProcedures(Set<MedicalProcedure> procedures) {
		this.procedures = procedures;
	}
	public Set<Claims> getClaims() {
		return claims;
	}
	public void setClaims(Set<Claims> claims) {
		this.claims = claims;
	}
	
	// One-to-Many relationships
    private Set<Doctor> doctors;
    private Set<Account> accounts;
    private Set<Appointment> appointments;
    private Set<MedicalProcedure> procedures;
    private Set<Claims> claims;
    
}