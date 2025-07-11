package com.infinite.jsf.admin.dao;

import java.util.List;

import com.infinite.jsf.pharmacy.model.Pharmacy;

public interface ReviewPharmacyaDao {

	List<Pharmacy> reviewPharmacyDetails();
	
	Pharmacy searchPharmacyById(String pharmacyId);
	
	String updatePharmacyStatus(Pharmacy pharmacy,String status);

}
