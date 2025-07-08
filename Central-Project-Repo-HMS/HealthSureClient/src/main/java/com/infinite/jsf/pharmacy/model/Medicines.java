package com.infinite.jsf.pharmacy.model;

import java.util.Date;
import java.util.Set;

public class Medicines {
	private String medicineId;
    private String medicineName;
    private String description;
    private int quantityInStock;
    private Date expiryDate;
    private double unitPrice;
    private Pharmacy pharmacy;
    private String purpose;
    private String batchNo;
    
    private Set<DispensedMedicines> dispensedMedicines;

    public Set<DispensedMedicines> getDispensedMedicines() {
        return dispensedMedicines;
    }

    public void setDispensedMedicines(Set<DispensedMedicines> dispensedMedicines) {
        this.dispensedMedicines = dispensedMedicines;
    }

    
    
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
    
    
}

