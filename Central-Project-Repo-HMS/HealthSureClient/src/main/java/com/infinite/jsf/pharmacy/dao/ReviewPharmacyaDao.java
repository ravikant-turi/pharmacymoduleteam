package com.infinite.jsf.pharmacy.dao;

import java.util.List;

import com.infinite.jsf.pharmacy.model.Pharmacy;

public interface ReviewPharmacyaDao {

	List<Pharmacy> reviewPharmacyDetails();
	
	Pharmacy searchPharmacyById(String pharmacyId);
	
	String updatePharmacyStatus(Pharmacy pharmacy);

}
