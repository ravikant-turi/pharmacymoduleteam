package com.infinite.jsf.pharmacy.controller;

import java.util.List;

import com.infinite.jsf.pharmacy.dao.ReviewPharmacyaDao;
import com.infinite.jsf.pharmacy.daoImpl.ReviewPharmacyaDaoImpl;
import com.infinite.jsf.pharmacy.model.DispensedEquipments;
import com.infinite.jsf.pharmacy.model.DispensedMedicines;
import com.infinite.jsf.pharmacy.model.Equipment;
import com.infinite.jsf.pharmacy.model.Medicines;
import com.infinite.jsf.pharmacy.model.Passwords;
import com.infinite.jsf.pharmacy.model.Pharmacists;
import com.infinite.jsf.pharmacy.model.Pharmacy;

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
		
	  reviewPharmacyaDao.updatePharmacyStatus(pharmacy);
		
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

}
