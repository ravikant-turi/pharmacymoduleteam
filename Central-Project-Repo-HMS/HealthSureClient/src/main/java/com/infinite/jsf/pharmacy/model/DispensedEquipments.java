
package com.infinite.jsf.pharmacy.model;

import java.util.Date;

public class DispensedEquipments {
    private String dispensedEquipId;
    private Equipment equipment; // FK
    private int quantityDispensed;
    private Date dispenseDate;
    private String prescriptionId;
    private String doctorId;
    private String hId;
    private String pharmacistName;
    private Pharmacy pharmacy; // FK

    // Getters and Setters
    public String getDispensedEquipId() {
        return dispensedEquipId;
    }

    public void setDispensedEquipId(String dispensedEquipId) {
        this.dispensedEquipId = dispensedEquipId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getQuantityDispensed() {
        return quantityDispensed;
    }

    public void setQuantityDispensed(int quantityDispensed) {
        this.quantityDispensed = quantityDispensed;
    }

    public Date getDispenseDate() {
        return dispenseDate;
    }

    public void setDispenseDate(Date dispenseDate) {
        this.dispenseDate = dispenseDate;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}

