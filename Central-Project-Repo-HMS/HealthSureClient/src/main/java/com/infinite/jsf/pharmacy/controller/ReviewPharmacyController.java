package com.infinite.jsf.pharmacy.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.sound.midi.ShortMessage;

import com.infinite.jsf.pharmacy.dao.ReviewPharmacyaDao;
import com.infinite.jsf.pharmacy.daoImpl.ReviewPharmacyaDaoImpl;
import com.infinite.jsf.pharmacy.model.DispensedEquipments;
import com.infinite.jsf.pharmacy.model.DispensedMedicines;
import com.infinite.jsf.pharmacy.model.Equipment;
import com.infinite.jsf.pharmacy.model.Medicines;
import com.infinite.jsf.pharmacy.model.Passwords;
import com.infinite.jsf.pharmacy.model.Pharmacists;
import com.infinite.jsf.pharmacy.model.Pharmacy;
import com.infinite.jsf.util.MailSend;

public class ReviewPharmacyController {

	private Pharmacy pharmacy;

	private ReviewPharmacyaDao reviewPharmacyaDao = new ReviewPharmacyaDaoImpl();

	private Medicines medicines;

	private Equipment equipment;

	private Pharmacists pharmacists;

	private DispensedMedicines dispensedMedicines;

	private DispensedEquipments dispensedEquipments;

	private Passwords passwords;

	List<Pharmacy> pharmaciesList;

	private String showValidatinMessage;

	public List<Pharmacy> showPharmacyAllForReview() {
		pharmaciesList = reviewPharmacyaDao.reviewPharmacyDetails();
		return pharmaciesList;
	}

//	validation 

	/*
	 * 
	 * 
	 */

	public String validatePharmacy(Pharmacy pharmacy) {
		
		FacesContext context=FacesContext.getCurrentInstance();
		
		if(pharmacy.getStatus().equals("ACCEPTED")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,pharmacy.getPharmacyId()+"Already Approved ",null));
            return null;
		}

		if (validatePharmacyDetails(pharmacy)) {
			
			
			reviewPharmacyaDao.updatePharmacyStatus(pharmacy);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,pharmacy.getPharmacyId()+"Approved succussfully",null));
			
			showValidatinMessage=pharmacy.getPharmacyId()+"Approved succussfully";
			
		}else {
			MailSend.sendInfo(pharmacy.getEmail(), " PHARMACY STATUS : REJECTED " , showValidatinMessage +"  \n  BY Adimin :  \n Ravikant Turi"); 
		}

		return null;
	}

//	
	private Pharmacy selectedPharmacy;

	public void setSelectedPharmacy(Pharmacy selectedPharmacy) {
		this.selectedPharmacy = selectedPharmacy;
	}

	public Pharmacy getSelectedPharmacy() {
		return selectedPharmacy;
	}

	// Navigate to view medicines page
	public String viewMedicines(Pharmacy pharmacy) {

		this.selectedPharmacy = pharmacy;
		System.out.println("=========================");
		System.out.println(selectedPharmacy);
		return "viewmedicinesR"; // navigate to viewmedicines.jsp
	}

	// View Equipments
	public String viewEquipments(Pharmacy pharmacy) {
		this.selectedPharmacy = pharmacy;
		System.out.println("=== Viewing Equipments for: " + selectedPharmacy.getPharmacyId());
		return "viewequipmentsR"; // Should match viewequipmentsR.jsp or xhtml
	}

	// View Pharmacists
	public String viewPharmacists(Pharmacy pharmacy) {
		this.selectedPharmacy = pharmacy;
		System.out.println("=== Viewing Pharmacists for: " + selectedPharmacy.getPharmacyId());
		return "viewpharmacistsR"; // Should match viewpharmacistsR.jsp or xhtml
	}

	// View Dispensed Medicines
	public String viewDispensedMedicines(Pharmacy pharmacy) {
		this.selectedPharmacy = pharmacy;
		System.out.println("=== Viewing Dispensed Medicines for: " + selectedPharmacy.getPharmacyId());
		return "viewdispensedmedicinesR"; // Should match viewdispensedmedicinesR.jsp or xhtml
	}

	// View Dispensed Equipments
	public String viewDispensedEquipments(Pharmacy pharmacy) {
		this.selectedPharmacy = pharmacy;
		System.out.println("=== Viewing Dispensed Equipments for: " + selectedPharmacy.getPharmacyId());
		return "viewdispensedequipmentsR"; // Should match viewdispensedequipmentsR.jsp or xhtml
	}

	// View Passwords
	public String viewPasswords(Pharmacy pharmacy) {
		this.selectedPharmacy = pharmacy;
		System.out.println("=== Viewing Passwords for: " + selectedPharmacy.getPharmacyId());
		return "viewpasswordsR"; // Should match viewpasswordsR.jsp or xhtml
	}

	/*
	 * this is for validation code
	 */

	public boolean validatePharmacyDetails(Pharmacy pharmacy) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		String aadhar = pharmacy.getAadhar();
		String licenseNo = pharmacy.getLicenseNo();
		String gstNo = pharmacy.getGstNo();

		if (aadhar == null || !aadhar.matches("AADHAR\\d{6}")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Aadhar",
					"Must start with 'AADHAR' followed by 6 digits."));
			showValidatinMessage= "  Invalid Aadhar !! ;Must start with 'AADHAR' followed by 6 digits. And  Your Adhar is "+ aadhar;
			isValid = false;
		}

		if (licenseNo == null || !licenseNo.matches("LIC\\d{5}")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid License No",
					"Must start with 'LIC' followed by 5 digits."));
			showValidatinMessage +=" \n\n  Invalid License No !! Must start with 'LIC' followed by 5 digits. And Your LICENSE NO : "+ licenseNo;
			isValid = false;
		}

		if (gstNo == null || !gstNo.matches("GSTIN\\d{4}[A-Z]{2}")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid GST No",
					"Must start with 'GSTIN', followed by 4 digits and end with 2 uppercase letters."));
			
			showValidatinMessage +=" \n\n Invalid GST No Must start with 'GSTIN', followed by 4 digits and end with 2 uppercase letters. AND YOUR  GST No"+gstNo;
			isValid = false;
		}

		return isValid;
	}

	

//	GETTER AND STTER

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public ReviewPharmacyaDao getReviewPharmacyaDao() {
		return reviewPharmacyaDao;
	}

	public void setReviewPharmacyaDao(ReviewPharmacyaDao reviewPharmacyaDao) {
		this.reviewPharmacyaDao = reviewPharmacyaDao;
	}

	public Medicines getMedicines() {
		return medicines;
	}

	public void setMedicines(Medicines medicines) {
		this.medicines = medicines;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Pharmacists getPharmacists() {
		return pharmacists;
	}

	public void setPharmacists(Pharmacists pharmacists) {
		this.pharmacists = pharmacists;
	}

	public DispensedMedicines getDispensedMedicines() {
		return dispensedMedicines;
	}

	public void setDispensedMedicines(DispensedMedicines dispensedMedicines) {
		this.dispensedMedicines = dispensedMedicines;
	}

	public DispensedEquipments getDispensedEquipments() {
		return dispensedEquipments;
	}

	public void setDispensedEquipments(DispensedEquipments dispensedEquipments) {
		this.dispensedEquipments = dispensedEquipments;
	}

	public List<Pharmacy> getPharmaciesList() {
		return pharmaciesList;
	}

	public void setPharmaciesList(List<Pharmacy> pharmaciesList) {
		this.pharmaciesList = pharmaciesList;
	}

	public Passwords getPasswords() {
		return passwords;
	}

	public void setPasswords(Passwords passwords) {
		this.passwords = passwords;
	}

	public String getShowValidatinMessage() {
		return showValidatinMessage;
	}

	public void setShowValidatinMessage(String showValidatinMessage) {
		this.showValidatinMessage = showValidatinMessage;
	}

}
