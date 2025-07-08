
package com.infinite.jsf.pharmacy.model;

import java.util.Set;

public class Pharmacists {

    private String pharmacistId;
    private String pharmacistName;
    private String phoneNo;
    private String email;
    private Pharmacy pharmacy;

    private Set<DispensedMedicines> dispensedMedicines;
    private Set<DispensedEquipments> dispensedEquipments;

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Set<DispensedMedicines> getDispensedMedicines() {
        return dispensedMedicines;
    }

    public void setDispensedMedicines(Set<DispensedMedicines> dispensedMedicines) {
        this.dispensedMedicines = dispensedMedicines;
    }

    public Set<DispensedEquipments> getDispensedEquipments() {
        return dispensedEquipments;
    }

    public void setDispensedEquipments(Set<DispensedEquipments> dispensedEquipments) {
        this.dispensedEquipments = dispensedEquipments;
    }
}


