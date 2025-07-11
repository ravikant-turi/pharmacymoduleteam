package com.infinite.jsf.admin.controller;

import java.util.Comparator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.admin.dao.ReviewPharmacyaDao;
import com.infinite.jsf.admin.daoImpl.ReviewPharmacyaDaoImpl;
import com.infinite.jsf.pharmacy.model.DispensedEquipments;
import com.infinite.jsf.pharmacy.model.DispensedMedicines;
import com.infinite.jsf.pharmacy.model.Equipment;
import com.infinite.jsf.pharmacy.model.Medicines;
import com.infinite.jsf.pharmacy.model.Passwords;
import com.infinite.jsf.pharmacy.model.Pharmacists;
import com.infinite.jsf.pharmacy.model.Pharmacy;
import com.infinite.jsf.util.MailSend;

/*This controller is for pharmacy review and approval*/
public class ReviewPharmacyController {

	private Pharmacy pharmacy;

	private ReviewPharmacyaDao reviewPharmacyaDao=new ReviewPharmacyaDaoImpl();

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
	
	
/*
 * PAGINATION AND SORTING	
 */
	
	
	private List<Pharmacy> allPharmacies;
	private List<Pharmacy> paginatedPharmacies;
	private int page = 0;
	private int pageSize = 5;
	private String sortField = "pharmacyId";
	private boolean ascending = true;
	


	public int getTotalPages() {
	    return (int) Math.ceil((double) allPharmacies.size() / pageSize);
	}

	public ReviewPharmacyController() {
	    allPharmacies = reviewPharmacyaDao.reviewPharmacyDetails();
	    sortAndPaginate();
	}

	public void sort(String field) {
	    if (sortField.equals(field)) {
	        ascending = !ascending;
	    } else {
	        sortField = field;
	        ascending = true;
	    }
	    sortAndPaginate();
	}

	public void nextPage() {
	    if ((page + 1) * pageSize < allPharmacies.size()) {
	        page++;
	        sortAndPaginate();
	    }
	}

	public void previousPage() {
	    if (page > 0) {
	        page--;
	        sortAndPaginate();
	    }
	}

	private void sortAndPaginate() {
	    Comparator<Pharmacy> comparator = Comparator.comparing(p -> {
	        switch (sortField) {
	            case "pharmacyName": return p.getPharmacyName();
	            case "contactNo": return p.getContactNo();
	            case "aadhar": return p.getAadhar();
	            case "licenseNo": return p.getLicenseNo();
	            case "gstNo": return p.getGstNo();
	            case "status": return p.getStatus();
	            default: return p.getPharmacyId();
	        }
	    });

	    if (!ascending) {
	        comparator = comparator.reversed();
	    }

	    allPharmacies.sort(comparator);

	    int fromIndex = page * pageSize;
	    int toIndex = Math.min(fromIndex + pageSize, allPharmacies.size());
	    paginatedPharmacies = allPharmacies.subList(fromIndex, toIndex);
	}

	public List<Pharmacy> getPaginatedPharmacies() {
	    return paginatedPharmacies;
	}

	
	
	

//	update pharmacy

	/*
	 * 
	 * 
	 */

	public String validatePharmacy(Pharmacy pharmacy) {
		
		FacesContext context=FacesContext.getCurrentInstance();
		
		if(pharmacy.getStatus().equals("ACCEPTED")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,pharmacy.getPharmacyId()+"  Already Approved ",null));
            return null;
		}

		if (validatePharmacyDetails(pharmacy)) {
			
			
			reviewPharmacyaDao.updatePharmacyStatus(pharmacy,"ACCEPTED");
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,pharmacy.getPharmacyId()+"Approved succussfully",null));
			
			showValidatinMessage=pharmacy.getPharmacyId()+"Approved succussfully";
			
		}else {
			reviewPharmacyaDao.updatePharmacyStatus(pharmacy,"REJECTED");

			MailSend.sendInfo(pharmacy.getEmail(), " PHARMACY STATUS : REJECTED " , showValidatinMessage +"  \n By Admin :  \n Ravikant Turi"); 
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
			showValidatinMessage= "Invalid Aadhar !! ;Must start with 'AADHAR' followed by 6 digits. And  Your Adhar is "+ aadhar;
			isValid = false;
		}
		
		if (licenseNo == null || !licenseNo.matches("LIC\\d{5}")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid License No",
					"Must start with 'LIC' followed by 5 digits."));
			showValidatinMessage +="\n\nInvalid License No! \n . And Your LICENSE NO : " + licenseNo + "\n Must start with 'LIC' followed by 5 digits";
			isValid = false;
		}

		if (gstNo == null || !gstNo.matches("GSTIN\\d{4}[A-Z]{2}")) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid GST No",
					"Must start with 'GSTIN', followed by 4 digits and end with 2 uppercase letters."));
			
			showValidatinMessage +="\n\nInvalid GST No Must start with 'GSTIN', followed by 4 digits and end with 2 uppercase letters. AND YOUR  GST No"+gstNo;
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

	public List<Pharmacy> getAllPharmacies() {
		return allPharmacies;
	}

	public void setAllPharmacies(List<Pharmacy> allPharmacies) {
		this.allPharmacies = allPharmacies;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public void setPaginatedPharmacies(List<Pharmacy> paginatedPharmacies) {
		this.paginatedPharmacies = paginatedPharmacies;
	}

}
