package com.infinite.jsf.recipient.model;

import java.util.Date;
import java.util.List;

import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.insurance.model.SubscriptionStatus;
import com.infinite.jsf.insurance.model.SubscriptionType;

public class PatientInsuranceDetails {
	private String subscribeId;
	private String hId;
	private String patientName;
	private String companyName;
	private String planName;
	private Date enrollmentDate;

	public String getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(String subscribeId) {
		this.subscribeId = subscribeId;
	}

	@Override
	public String toString() {
		return "PatientInsuranceDetails [subscribeId=" + subscribeId + ", hId=" + hId + ", patientName=" + patientName
				+ ", companyName=" + companyName + ", planName=" + planName + ", enrollmentDate=" + enrollmentDate
				+ ", coverageStartDate=" + coverageStartDate + ", coverageEndDate=" + coverageEndDate
				+ ", coverageStatus=" + coverageStatus + ", coverageType=" + coverageType + ", coverageLimit="
				+ coverageLimit + ", remaining=" + remaining + ", claimed=" + claimed + ", lastClaimDate="
				+ lastClaimDate + ", subscribedMembers=" + subscribedMembers + "]";
	}

	private Date coverageStartDate;
	private Date coverageEndDate;
	private SubscriptionStatus coverageStatus;
	private SubscriptionType coverageType;
	private double coverageLimit;
	private double remaining;
	private double claimed;

	public List<SubscribedMember> getSubscribedMembers() {
		return subscribedMembers;
	}

	public void setSubscribedMembers(List<SubscribedMember> subscribedMembers) {
		this.subscribedMembers = subscribedMembers;
	}

	private Date lastClaimDate;
	private List<SubscribedMember> subscribedMembers;

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Date getCoverageStartDate() {
		return coverageStartDate;
	}

	public void setCoverageStartDate(Date coverageStartDate) {
		this.coverageStartDate = coverageStartDate;
	}

	public Date getCoverageEndDate() {
		return coverageEndDate;
	}

	public void setCoverageEndDate(Date coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}

	public SubscriptionStatus getCoverageStatus() {
		return coverageStatus;
	}

	public void setCoverageStatus(SubscriptionStatus coverageStatus) {
		this.coverageStatus = coverageStatus;
	}

	public SubscriptionType getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(SubscriptionType coverageType) {
		this.coverageType = coverageType;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public double getClaimed() {
		return claimed;
	}

	public void setClaimed(double claimed) {
		this.claimed = claimed;
	}

	public Date getLastClaimDate() {
		return lastClaimDate;
	}

	public void setLastClaimDate(Date lastClaimDate) {
		this.lastClaimDate = lastClaimDate;
	}

	public PatientInsuranceDetails(String subscribeId, String hId, String patientName, String companyName,
			String planName, Date enrollmentDate, Date coverageStartDate, Date coverageEndDate,
			SubscriptionStatus coverageStatus, SubscriptionType coverageType, double limit, double remaining,
			double claimed, Date lastClaimDate, List<SubscribedMember> subscribedMembers) {
		super();
		this.subscribeId = subscribeId;
		this.hId = hId;
		this.patientName = patientName;
		this.companyName = companyName;
		this.planName = planName;
		this.enrollmentDate = enrollmentDate;
		this.coverageStartDate = coverageStartDate;
		this.coverageEndDate = coverageEndDate;
		this.coverageStatus = coverageStatus;
		this.coverageType = coverageType;
		this.coverageLimit = coverageLimit;
		this.remaining = remaining;
		this.claimed = claimed;
		this.lastClaimDate = lastClaimDate;
		this.subscribedMembers = subscribedMembers;
	}

	public double getCoverageLimit() {
		return coverageLimit;
	}

	public void setCoverageLimit(double coverageLimit) {
		this.coverageLimit = coverageLimit;
	}

	public PatientInsuranceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
