package com.infinite.ejb.pharmacy.bean;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.infinite.ejb.pharmacy.dao.UpdateEquipmentsDao;
import com.infinite.ejb.pharmacy.dao.UpdateMedicinesDao;
import com.infinite.ejb.pharmacy.daoImpl.UpdateMedicinesDaoImpl;
import com.infinite.ejb.pharmacy.model.Medicines;



/**
 * Session Bean implementation class PharmacyBean
 */
@Stateless
@Remote(PharmacyBeanRemote.class)
public class PharmacyBean implements PharmacyBeanRemote {
	static UpdateEquipmentsDao updateEquipmentImpl;
	static UpdateMedicinesDao updateMedicineImpl;

	static {
		updateMedicineImpl = new UpdateMedicinesDaoImpl();
	}

    /**
     * Default constructor. 
     */
    public PharmacyBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean updateMedicineDetails(Medicines med) {
		// TODO Auto-generated method stub
		return updateMedicineImpl.updateMedicineDetails(med);
	}

}
