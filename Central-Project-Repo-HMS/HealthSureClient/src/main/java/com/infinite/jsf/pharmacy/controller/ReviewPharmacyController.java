package com.infinite.jsf.pharmacy.controller;

import java.util.List;

import com.infinite.jsf.pharmacy.dao.PharmacyDao;
import com.infinite.jsf.pharmacy.dao.ReviewPharmacyaDao;
import com.infinite.jsf.pharmacy.daoImpl.PharmacyDaoImpl;
import com.infinite.jsf.pharmacy.daoImpl.ReviewPharmacyaDaoImpl;
import com.infinite.jsf.pharmacy.model.Pharmacy;

public class ReviewPharmacyController {
	Pharmacy pharmacy;
    ReviewPharmacyaDao reviewPharmacyaDao=new ReviewPharmacyaDaoImpl();
	List<Pharmacy>pharmaciesList;
	
	public List<Pharmacy> showPharmacyAll() {
		pharmaciesList=reviewPharmacyaDao.reviewPharmacyDetails();
		return pharmaciesList;
	}

}
