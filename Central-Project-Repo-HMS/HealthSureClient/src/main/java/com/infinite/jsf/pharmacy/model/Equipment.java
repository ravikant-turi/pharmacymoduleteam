
package com.infinite.jsf.pharmacy.model;

import java.sql.Date;
import java.util.Set;

public class Equipment {

	private String equipmentId;
    private String equipmentName;
    private String description;
    private int quantity;
    private double unitPrice;
    private String purpose;
    private Date purchaseDate;
    private Pharmacy pharmacy;
    private String status;
    
    private Set<DispensedEquipments> dispensedEquipments;

    public Set<DispensedEquipments> getDispensedEquipments() {
        return dispensedEquipments;
    }

    public void setDispensedEquipments(Set<DispensedEquipments> dispensedEquipments) {
        this.dispensedEquipments = dispensedEquipments;
    }

    
    
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
    
    
	
}

