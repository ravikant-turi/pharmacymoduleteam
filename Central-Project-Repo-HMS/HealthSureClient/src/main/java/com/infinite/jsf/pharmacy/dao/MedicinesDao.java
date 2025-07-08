package com.infinite.jsf.pharmacy.dao;

import java.util.List;
import com.infinite.jsf.pharmacy.model.Medicines;

public interface MedicinesDao {
    List<Medicines> getMedicinesByPharmacyId(String pharmacyId);
    List<Medicines> searchMedicinesStartingWith(String name, String pharmacyId);
    List<Medicines> searchMedicinesContaining(String name, String pharmacyId);
}