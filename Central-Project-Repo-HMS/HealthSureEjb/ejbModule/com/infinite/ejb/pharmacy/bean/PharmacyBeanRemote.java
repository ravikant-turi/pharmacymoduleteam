package com.infinite.ejb.pharmacy.bean;

import javax.ejb.Remote;

import com.infinite.ejb.pharmacy.model.Medicines;

@Remote
public interface PharmacyBeanRemote {

	public boolean updateMedicineDetails(com.infinite.ejb.pharmacy.model.Medicines med);
}
