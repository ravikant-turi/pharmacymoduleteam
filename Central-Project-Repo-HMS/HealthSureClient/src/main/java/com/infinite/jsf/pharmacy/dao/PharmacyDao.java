package com.infinite.jsf.pharmacy.dao;

import com.infinite.jsf.pharmacy.model.Pharmacy;

public interface PharmacyDao {

	String addPharmacy(Pharmacy pharmacy);
	
	String generatePassword(String email , int otp);
	public boolean validateTempPassword(String email, String password);
	
	boolean validatePassword(String email, String password);
	
	String updatePassword(String email, String pwd);
	
}


