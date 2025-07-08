
package com.infinite.jsf.pharmacy.model;

import java.util.Date;

public class DispensedMedicines {

    private String dispenseId;
    private Medicines medicines;     // Many-to-one
    private Pharmacy pharmacy;      // Many-to-one
    private int quantityDispensed;
    private Date dispenseDate;
    private String prescriptionId;
    private String doctorId;
    private String hId;
    private String pharmacistName;

    // Getters and Setters

    public String getDispenseId() {
        return dispenseId;
    }

    public void setDispenseId(String dispenseId) {
        this.dispenseId = dispenseId;
    }

    public Medicines getMedicines() {
        return medicines;
    }

    public void setMedicines(Medicines medicines) {
        this.medicines = medicines;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
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
}



