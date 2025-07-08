package com.infinite.jsf.pharmacy.dao;

import java.util.List;

import com.infinite.jsf.pharmacy.model.Equipment;

public interface EquipmentDao {

	 List<Equipment> getEquipmentByPharmacyId(String pharmacyId);
	    List<Equipment> searchEquipmentStartingWith(String name, String pharmacyId);
	    List<Equipment> searchEquipmentContaining(String name, String pharmacyId);
}
