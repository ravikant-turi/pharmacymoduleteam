package com.infinite.jsf.pharmacy.controller;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.infinite.jsf.pharmacy.daoImpl.PharmacyDaoImpl;
import com.infinite.jsf.pharmacy.model.DispensedEquipments;
import com.infinite.jsf.pharmacy.model.DispensedMedicines;
import com.infinite.jsf.pharmacy.model.Equipment;
import com.infinite.jsf.pharmacy.model.Medicines;
import com.infinite.jsf.pharmacy.model.Pharmacists;
import com.infinite.jsf.pharmacy.model.Pharmacy;

import java.sql.Timestamp;
import java.util.regex.Pattern;



public class PharmacyController {

	private PharmacyDaoImpl pharmacyDao;
    private Pharmacy pharmacy;
    private String confirmPassword;
   
    
    

    public PharmacyDaoImpl getPharmacyDao() {
        return pharmacyDao;
    }

    public void setPharmacyDao(PharmacyDaoImpl pharmacyDao) {
        this.pharmacyDao = pharmacyDao;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

 
    public String proceedToPharmacyDetails() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean isValid = true;

        if(pharmacy.getFirstName() == null || pharmacy.getFirstName().trim().isEmpty()) {
            context.addMessage("form:firstName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "First name is required", null));
            isValid = false;
        }
        if(!isAlphabetic(pharmacy.getFirstName())) {
        	context.addMessage("form:firstName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Special symbol is not allowed", null));
            isValid = false;
        }

        if(pharmacy.getLastName() == null || pharmacy.getLastName().trim().isEmpty()) {
            context.addMessage("form:lastName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Last name is required", null));
            isValid = false;
        }
        if(!isAlphabetic(pharmacy.getLastName())) {
        	context.addMessage("form:lastName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Special symbol is not allowed", null));
            isValid = false;
        }

        if (pharmacy.getGender() == null || pharmacy.getGender().trim().isEmpty()) {
            context.addMessage("form:gender", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gender is required.", null));
            isValid = false;
        }

        if (pharmacyDao.isOwnerMobileExist(pharmacy.getOwnerMobile())) {
            context.addMessage("form:ownerMobile", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Owner Mobile already registered.", null));
            isValid = false;
        }
        if (pharmacy.getOwnerMobile() == null || !pharmacy.getOwnerMobile().matches("[1-9]\\d{9}")) {
            context.addMessage("form:ownerMobile", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mobile number must be 10 digits.", null));
            isValid = false;
        }
      
        
        
        if (pharmacy.getOwnerAddress() == null || pharmacy.getOwnerAddress().trim().isEmpty()) {
            context.addMessage("form:ownerAddress", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Owner address is required.", null));
            isValid = false;
        }
        
        if (pharmacy.getAadhar() == null || !pharmacy.getAadhar().matches("\\d{4}-\\d{4}-\\d{4}")) {
            context.addMessage("form:aadharNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aadhar must be in the format XXXX-XXXX-XXXX.", null));
            isValid = false;
        }

        if (pharmacyDao.isAadharExists(pharmacy.getAadhar())) {
            context.addMessage("form:aadharNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aadhar already registered.", null));
            isValid = false;
        }

        if (pharmacy.getOwnerEmail() == null || !isValidEmail(pharmacy.getOwnerEmail())) {
            context.addMessage("form:ownerEmail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid owner email.", null));
            isValid = false;
        }
        
        if (pharmacyDao.isOwnerEmailExist(pharmacy.getOwnerEmail())) {
            context.addMessage("form:ownerEmail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oner email allready register registered.", null));
            isValid = false;
        }

        if (!isValid) {
            context.validationFailed();
            return null;
        }

        return "AddPharmacy.jsf?faces-redirect=true";
    }


    public String registerPharmacy() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean isValid = true;

        if (pharmacy.getPharmacyName() == null || pharmacy.getPharmacyName().length() < 5 || pharmacy.getPharmacyName().length() > 20) {
            context.addMessage("form:pharmacyName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pharmacy Name must be 5 to 10 characters.", null));
            isValid = false;
        }
        
        if (pharmacy.getLicenseNo() == null || !pharmacy.getLicenseNo().matches("[A-Z]{2}/[0-9]{4}/[0-9]{5}/[A-Z]{1}")) {
            context.addMessage("form:licenseNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "License Number must be of 12 alphanumeric format [AA/0000/00000/A.]", null));
            isValid = false;
        }

//        if (pharmacy.getGstNo() == null || !pharmacy.getGstNo().matches("[0-9A-Z]{15}")) {
//            context.addMessage("form:gstNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "GST Number must be 15 alphanumeric characters formate [0-9]-2d,[A-Z and  0-9].", null));
//            isValid = false;
//        }

        if (pharmacy.getGstNo() == null || !pharmacy.getGstNo().matches("[0-9]{2}[0-9A-Z]{10}[0-9]{1}[A-Z]{1}[0-9]{1}")) {
            context.addMessage("form:gstNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "GST Number must be 15 alphanumeric characters formate [0-9]-2d,[A-Z:0-9]-10d,[0-9][A-Z][0-9].", null));
            isValid = false;
        }


        if (pharmacy.getEmail() == null || !isValidEmail(pharmacy.getEmail())) {
            context.addMessage("form:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid email format.", null));
            isValid = false;
        }
      if (pharmacyDao.isEmailExist(pharmacy.getEmail())) {
      context.addMessage("form:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, " email allready registered.", null));
      isValid = false;
  }

        if (pharmacy.getContactNo() == null || !pharmacy.getContactNo().matches("[1-9]\\d{9}")) {
            context.addMessage("form:contactNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contact Number must be 10 digits.", null));
            isValid = false;
        }
        if (pharmacyDao.isPharmacyMobileExist(pharmacy.getContactNo())) {
            context.addMessage("form:contactNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pharmacy Mobile already registered.", null));
            isValid = false;
        }

        if (pharmacy.getAddressLine1() == null || pharmacy.getAddressLine1().trim().isEmpty()) {
            context.addMessage("form:addressLine1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Address Line 1 is required.", null));
            isValid = false;
        }

        if (pharmacy.getCity() == null || pharmacy.getCity().trim().isEmpty()) {
            context.addMessage("form:city", new FacesMessage(FacesMessage.SEVERITY_ERROR, "City is required.", null));
            isValid = false;
        }
        if(!isAlphabetic(pharmacy.getCity())) {
        	context.addMessage("form:city", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Special symbol is not allowed", null));
            isValid = false;
        }

        if (pharmacy.getState() == null || pharmacy.getState().trim().isEmpty()) {
            context.addMessage("form:state", new FacesMessage(FacesMessage.SEVERITY_ERROR, "State is required.", null));
            isValid = false;
        }
        if(!isAlphabetic(pharmacy.getState())) {
        	context.addMessage("form:state", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Special symbol is not allowed", null));
            isValid = false;
        }

        if (pharmacy.getPinCode() == null || !pharmacy.getPinCode().matches("\\d{6}")) {
            context.addMessage("form:pinCode", new FacesMessage(FacesMessage.SEVERITY_ERROR, "PIN Code must be 6 digits.", null));
            isValid = false;
        }
        

        if (pharmacyDao.isGstExists(pharmacy.getGstNo())) {
            context.addMessage("form:gstNo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "GST number already registered.", null));
            isValid = false;
        }
  
        if (!isValid) {
            context.validationFailed();
            return null;
        }
        

        pharmacy.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        String result = pharmacyDao.addPharmacy(pharmacy);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
        return "Otp.jsf?faces-redirect=true";
        
    }

    private boolean isAlphabetic(String input) {
    	return input != null && input.matches("^[a-zA-Z]+$");
    }

    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    
     // Validates login - if active,-> go to home
     
    public String validateLogin() {
    	
        String email = pharmacy.getEmail();
        String password = pharmacy.getPassword();

        
        if (pharmacyDao.validatePassword(email, password)) {
            Pharmacy found = pharmacyDao.getPharmacyByEmail(email);

            if (!"Active".equalsIgnoreCase(found.getStatus())) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Account not activated. Please wait for admin approval.", null));
                return null;
            }

            //setting session attributes to use further
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("pharmacy_id", found.getPharmacyId());
            context.getExternalContext().getSessionMap().put("pharmacy_name", found.getPharmacyName());
            context.getExternalContext().getSessionMap().put("owner_name", found.getFirstName() + " " + found.getLastName());
            context.getExternalContext().getSessionMap().put("email", found.getEmail());
            context.getExternalContext().getSessionMap().put("address", found.getAddressLine1());
            context.getExternalContext().getSessionMap().put("city", found.getCity());
            context.getExternalContext().getSessionMap().put("state", found.getState());
            context.getExternalContext().getSessionMap().put("zip_code", found.getPinCode());
            
            return "Pharmacy.jsf?faces-redirect=true";
        }

        if (pharmacyDao.validateTempPassword(email, password)) {
            return "Login.jsf?faces-redirect=true";
        }

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
        return null;
    }

    
     // Checks temporary password and redirects to reset
     
    public String validateTempPassword() {
    	
        String email = pharmacy.getEmail();
        String password = pharmacy.getPassword();
        
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", email);

        boolean isValid = pharmacyDao.validateTempPassword(email, password);

        if (isValid) {
            return "ResetPasword.jsf?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid password. Please check your email.", null));
            return null;
        }
    }

    
     // OTP verification and generating temp password
     
    public String generatePassword(String email, int otp) {
        String result = pharmacyDao.generatePassword(email, otp);

        if (result.contains("Otp verified")) {
            return "ValidatePassword.jsf?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, result, null));
            return null;
        }
    }

    /**
     * Resetting password after OTP
     */
//    public String updatePassword(String email, String pwd) {
//        if (!pwd.equals(confirmPassword)) {
//            FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match", null));
//            return null;
//        }
//
//        String result = pharmacyDao.updatePassword(email, pwd);
//        if ("Pharmacy Updated Successfully".equals(result)) {
//            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", "Password updated successfully.");
//            return "login.jsf?faces-redirect=true";
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_ERROR, result, null));
//            return null;
//        }
//    }
    
    private boolean isStrongPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }


    public String updatePassword(String email, String pwd) {
        FacesContext context = FacesContext.getCurrentInstance();

        if (!pwd.equals(confirmPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match", null));
            return null;
        }

        if (!isStrongPassword(pwd)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character.", null));
            return null;
        }

        String result = pharmacyDao.updatePassword(email, pwd);
        if ("Pharmacy Updated Successfully".equals(result)) {
            context.getExternalContext().getFlash().put("message", "Password updated successfully.");
            return "Login.jsf?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, result, null));
            return null;
        }
    }

    
    /**
     * Resends OTP
     */
    public String resendOtp() {
        String email = pharmacy.getEmail();
        String result = pharmacyDao.resendOtp(email);
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
        return null;
    }
    
    //logout
    public String logout() {

        try {

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "/home/Home.jsp?faces-redirect=true";

        } catch (Exception e) {

            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,

                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logout failed", null));

            return null;

        }

    }
    
   
}
