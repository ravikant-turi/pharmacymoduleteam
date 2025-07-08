package com.infinite.jsf.provider.model;


import java.util.Set;

public class Doctor {
    private String doctorId;
    private Provider provider;
    private String doctorName;
    private String qualification;
    private String specialization;
    private String licenseNo;
    private String email;
    private String address;
    private String gender;
    private String password;
    private LoginStatus loginStatus;
    private DoctorStatus doctorStatus;
    
    public String getDoctorId() {
		return doctorId;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginStatus getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}
	public DoctorStatus getDoctorStatus() {
		return doctorStatus;
	}
	public void setDoctorStatus(DoctorStatus doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	public Set<DoctorAvailability> getAvailabilities() {
		return availabilities;
	}
	public void setAvailabilities(Set<DoctorAvailability> availabilities) {
		this.availabilities = availabilities;
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
	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	// One-to-Many relationships
    private Set<DoctorAvailability> availabilities;
    private Set<Appointment> appointments;
    private Set<MedicalProcedure> procedures;
    private Set<Prescription> prescriptions;

	
   
    
    // Constructors, getters and setters
}