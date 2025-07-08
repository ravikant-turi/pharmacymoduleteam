package com.infinite.ejb.pharmacy.bean;

import javax.ejb.Remote;

@Remote
public interface PharmacyBeanRemote {

	public boolean updateMedicineDetails(com.infinite.ejb.pharmacy.model.Medicines med);
}
