
package com.infinite.ejb.pharmacy.model;

import java.io.Serializable;

public class Passwords implements Serializable {
	
	private int passwordId;
    private Pharmacy pharmacy;
    private String password;
    
	public int getPasswordId() {
		return passwordId;
	}
	public void setPasswordId(int passwordId) {
		this.passwordId = passwordId;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    

}

