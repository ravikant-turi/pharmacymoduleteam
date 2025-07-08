package com.infinite.jsf.recipient.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.infinite.jsf.admin.model.PaymentHistory;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.pharmacy.model.DispensedEquipments;
import com.infinite.jsf.pharmacy.model.DispensedMedicines;
import com.infinite.jsf.provider.model.Appointment;
import com.infinite.jsf.provider.model.Claims;
import com.infinite.jsf.provider.model.MedicalProcedure;
import com.infinite.jsf.provider.model.Prescription;

public class Recipient {
	private String hId; // Health ID
	private String firstName;
	private String lastName;
	private String mobile;
	private String userName;
	private Gender gender;
	private Date dob;
	private String address;
	private Timestamp createdAt;
	private String password;
	private String email;
	private RecipientStatus status;
	private Integer loginAttempts;
	private Timestamp lockedUntil;
	private Timestamp lastLogin;
	private Timestamp passwordUpdatedAt;

	// Relationships
	private Set<Appointment> appointments;
	private Set<MedicalProcedure> procedures;
	private Set<Subscribe> subscriptions;
	private Set<Prescription> prescriptions;
	private Set<DispensedMedicines> dispensedMedicines;
	private Set<DispensedEquipments> dispensedEquipments;
	private Set<Claims> claims;
	private Set<PaymentHistory> paymentHistories;

	// Constructors
	public Recipient() {
	}

	public Recipient(String hId, String firstName, String lastName, String mobile, String userName, Gender gender,
			Date dob, String address, String password, String email) {
		this.hId = hId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.userName = userName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.email = email;
		this.status = RecipientStatus.ACTIVE;
		this.loginAttempts = 0;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}

	// Getters and Setters
	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RecipientStatus getStatus() {
		return status;
	}

	public void setStatus(RecipientStatus status) {
		this.status = status;
	}

	public Integer getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public Timestamp getLockedUntil() {
		return lockedUntil;
	}

	public void setLockedUntil(Timestamp lockedUntil) {
		this.lockedUntil = lockedUntil;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getPasswordUpdatedAt() {
		return passwordUpdatedAt;
	}

	public void setPasswordUpdatedAt(Timestamp passwordUpdatedAt) {
		this.passwordUpdatedAt = passwordUpdatedAt;
	}

	// Relationship getters and setters
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

	public Set<Subscribe> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscribe> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Set<DispensedMedicines> getDispensedMedicines() {
		return dispensedMedicines;
	}

	public void setDispensedMedicines(Set<DispensedMedicines> dispensedMedicines) {
		this.dispensedMedicines = dispensedMedicines;
	}

	public Set<DispensedEquipments> getDispensedEquipments() {
		return dispensedEquipments;
	}

	public void setDispensedEquipments(Set<DispensedEquipments> dispensedEquipments) {
		this.dispensedEquipments = dispensedEquipments;
	}

	public Set<Claims> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claims> claims) {
		this.claims = claims;
	}

	public Set<PaymentHistory> getPaymentHistories() {
		return paymentHistories;
	}

	public void setPaymentHistories(Set<PaymentHistory> paymentHistories) {
		this.paymentHistories = paymentHistories;
	}

	@Override
	public String toString() {
		return "Recipient{" + "hId='" + hId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", mobile='" + mobile + '\'' + ", userName='" + userName + '\'' + ", gender=" + gender
				+ ", dob=" + dob + ", status=" + status + '}';
	}
}