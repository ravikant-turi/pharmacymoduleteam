package com.infinite.jsf.pharmacy.model;



import java.sql.Timestamp;

public class PharmacyOtp {

    private int otpId;
    private String pharmacyId;
    private String otpCode;
    private Purpose purpose;
    private String newPassword;
    private Status status;
    private Timestamp createdAt;
    private Timestamp expiresAt;
	public int getOtpId() {
		return otpId;
	}
	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}
	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public String getOtpCode() {
		return otpCode;
	}
	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}
	public Purpose getPurpose() {
		return purpose;
	}
	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(Timestamp expiresAt) {
		this.expiresAt = expiresAt;
	}
	@Override
	public String toString() {
		return "PharmacyOTP [otpId=" + otpId + ", pharmacyId=" + pharmacyId + ", otpCode=" + otpCode + ", purpose="
				+ purpose + ", newPassword=" + newPassword + ", status=" + status + ", createdAt=" + createdAt
				+ ", expiresAt=" + expiresAt + "]";
	}
	public PharmacyOtp(int otpId, String pharmacyId, String otpCode, Purpose purpose, String newPassword, Status status,
			Timestamp createdAt, Timestamp expiresAt) {
		super();
		this.otpId = otpId;
		this.pharmacyId = pharmacyId;
		this.otpCode = otpCode;
		this.purpose = purpose;
		this.newPassword = newPassword;
		this.status = status;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
	}
	public PharmacyOtp() {
		super();
		// TODO Auto-generated constructor stub
	}
    	
}

