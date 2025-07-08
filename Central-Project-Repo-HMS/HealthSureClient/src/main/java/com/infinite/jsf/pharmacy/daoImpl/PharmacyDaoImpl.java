package com.infinite.jsf.pharmacy.daoImpl;

import java.sql.Timestamp;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.infinite.jsf.pharmacy.dao.PharmacyDao;
import com.infinite.jsf.pharmacy.model.Passwords;
import com.infinite.jsf.pharmacy.model.Pharmacy;
import com.infinite.jsf.pharmacy.model.PharmacyOtp;
import com.infinite.jsf.pharmacy.model.Purpose;
import com.infinite.jsf.pharmacy.model.Status;
import com.infinite.jsf.util.MailSend;
import com.infinite.jsf.util.SessionHelper;


public class PharmacyDaoImpl implements PharmacyDao {

    Session session;
// generating 6 digit otp
    public int generateOtp() {
        return 100000 + new Random().nextInt(900000);
    }

    public static String getNextPharmacyId(Session session) {
        String prefix = "PHM";
        String hql = "select max(pharmacyId) from Pharmacy";
        String maxId = (String) session.createQuery(hql).uniqueResult();
        if (maxId == null) {
            return prefix + "001";
        }
        int id = Integer.parseInt(maxId.substring(prefix.length()));
        id++;
        return String.format("%s%03d", prefix, id);
    }
// add/register pharmacy
    @Override
	public String addPharmacy(Pharmacy pharmacy) {
		session = SessionHelper.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();

        String nextId = getNextPharmacyId(session);
        pharmacy.setPharmacyId(nextId);
        pharmacy.setStatus("Pending");
        
        //test.....
        System.out.println("Saving pharmacy: " + pharmacy.getPharmacyId() + " | Owner: " 
        	    + pharmacy.getFirstName() + " " + pharmacy.getLastName() + " | Pharmacy: " + pharmacy.getPharmacyName());

        //some time inserction fail 
        try {
        session.save(pharmacy);
        trans.commit();
        }catch(Exception e) {
        	if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
        		return "Aadhar or GST allready exist";
        	}
        }
        int code = generateOtp();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp expiry = new Timestamp(now.getTime() + 2 * 60 * 1000);

        PharmacyOtp otp = new PharmacyOtp();
        otp.setOtpCode(String.valueOf(code));
        otp.setStatus(Status.PENDING);
        otp.setPurpose(Purpose.REGISTER);
        otp.setPharmacyId(pharmacy.getPharmacyId());
        otp.setCreatedAt(now);
        otp.setExpiresAt(expiry);

        trans = session.beginTransaction();
        session.save(otp);
        trans.commit();

        String subject = "Hi " + pharmacy.getPharmacyName() + ", your account is created";
        String body = "Your OTP Code is " + code + ". Please use this to set your password.";
        MailSend.sendInfo(pharmacy.getEmail(), subject, body);

        return "Pharmacy record added and OTP sent via email.";
	}


    public String getAlphaNumericString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    
    // otp generate function
    @Override
	public String generatePassword(String email, int otp) {
	       session = SessionHelper.getSessionFactory().openSession();
	        Query pharmacyQuery = session.createQuery("from Pharmacy where email = :email");
	        pharmacyQuery.setParameter("email", email);
	        Pharmacy pharmacy = (Pharmacy) pharmacyQuery.uniqueResult();

	        if (pharmacy == null) {
	            return "No pharmacy found with the provided email.";
	        }

	        
	        System.out.println("Validating OTP:");
	        System.out.println("Email: " + email);
	        System.out.println("Pharmacy ID: " + pharmacy.getPharmacyId());
	        System.out.println("OTP: " + otp);
	        System.out.println("Expected status: PENDING");

	        
	        String hql = "from PharmacyOtp where pharmacyId = :pharmacyId and otpCode = :otp and status = :status";
	        Query query = session.createQuery(hql);
	        query.setParameter("pharmacyId", pharmacy.getPharmacyId());
	        query.setParameter("otp", String.valueOf(otp));
	        query.setParameter("status", Status.PENDING);

	        PharmacyOtp objOtp = (PharmacyOtp) query.uniqueResult();

	        if (objOtp != null) {
	            Timestamp now = new Timestamp(System.currentTimeMillis());
	            if (now.after(objOtp.getExpiresAt())) {
	                // Mark OTP as expired
	                Transaction tx = session.beginTransaction();
	                objOtp.setStatus(Status.EXPIRED);  
	                session.update(objOtp);
	                tx.commit();

	                return "Otp expired. Please resend OTP.";
	            }

	            // OTP is valid and not expired, proceed
	            String pwd = getAlphaNumericString();
	            objOtp.setStatus(Status.VERIFIED);
	            objOtp.setNewPassword(pwd);

	            Transaction trans = session.beginTransaction();
	            session.update(objOtp);
	            trans.commit();

	            String body = "Your One-Time Password for Login is: " + pwd;
	            MailSend.sendInfo(email, "One Time Password", body);

	            return "Otp verified New password has been sent to your email.";
	        }

	        return "Invalid Otp or email.";
	}


	@Override
	public boolean validatePassword(String email, String password) {
		session = SessionHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Pharmacy where email = :email");
        query.setParameter("email", email);
        Pharmacy pharmacy = (Pharmacy) query.uniqueResult();

        return pharmacy != null && pharmacy.getPassword().equals(password);
	}
 
    
    

    public boolean validateTempPassword(String email, String password) {
        session = SessionHelper.getSessionFactory().openSession();

        Query pharmacyQuery = session.createQuery("from Pharmacy where email = :email");
        pharmacyQuery.setParameter("email", email);
        Pharmacy pharmacy = (Pharmacy) pharmacyQuery.uniqueResult();

        if (pharmacy == null) return false;

        Query otpQuery = session.createQuery("from PharmacyOtp where pharmacyId = :pharmacyId and status = :status");
        otpQuery.setParameter("pharmacyId", pharmacy.getPharmacyId());
        otpQuery.setParameter("status", Status.VERIFIED);

        PharmacyOtp otp = (PharmacyOtp) otpQuery.uniqueResult();

        return otp != null && otp.getNewPassword().equals(password);
    }

  
   

	@Override
	public String updatePassword(String email, String pwd) {
		session = SessionHelper.getSessionFactory().openSession();
        Transaction tx = null;

        // Step 1: Fetch pharmacy by email
        Query query = session.createQuery("from Pharmacy where email = :email");
        query.setParameter("email", email);
        Pharmacy pharmacy = (Pharmacy) query.uniqueResult();

        if (pharmacy != null) {
            tx = session.beginTransaction();

            // Step 2: Update the pharmacy's permanent password
            pharmacy.setPassword(pwd);
            session.update(pharmacy);
            
            //saving in passwords table also
            Passwords passRecords = new Passwords();
            passRecords.setPharmacy(pharmacy);
            passRecords.setPassword(pwd);
            session.save(passRecords);
            

            // Step 3: Get the latest verified OTP (if any)
            Query otpQuery = session.createQuery(
                "from PharmacyOtp where pharmacyId = :pharmacyId and status = :status order by createdAt desc"
            );
            otpQuery.setParameter("pharmacyId", pharmacy.getPharmacyId());
            otpQuery.setParameter("status", Status.VERIFIED);
            otpQuery.setMaxResults(1);

            PharmacyOtp otp = (PharmacyOtp) otpQuery.uniqueResult();

            if (otp != null) {
                // Step 4: Delete that OTP record (optional, for cleanup)
                session.delete(otp);

                // Optional: You could also delete all expired and pending OTPs
                Query cleanUp = session.createQuery(
                    "delete from PharmacyOtp where pharmacyId = :pharmacyId and status != :status"
                );
                cleanUp.setParameter("pharmacyId", pharmacy.getPharmacyId());
                cleanUp.setParameter("status", Status.VERIFIED);
                cleanUp.executeUpdate();
            }

            tx.commit();
            return "Pharmacy Updated Successfully";
        } else {
            return "No pharmacy found with the given email.";
        }
	}
    

    

    public Pharmacy getPharmacyByEmail(String email) {
        session = SessionHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Pharmacy where email = :email");
        query.setParameter("email", email);
        return (Pharmacy) query.uniqueResult();
    }
    
    public String resendOtp(String email) {
        session = SessionHelper.getSessionFactory().openSession();

        Query pharmacyQuery = session.createQuery("from Pharmacy where email = :email");
        pharmacyQuery.setParameter("email", email);
        Pharmacy pharmacy = (Pharmacy) pharmacyQuery.uniqueResult();

        if (pharmacy == null) {
            return "No pharmacy found with this email.";
        }

        int newOtp = generateOtp();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp expiry = new Timestamp(now.getTime() + 10 * 60 * 1000);

        // Invalidate previous OTPs by marking expired
        Transaction tx = session.beginTransaction();
        Query otpUpdate = session.createQuery("update PharmacyOtp set status = :expired where pharmacyId = :pharmacyId and status = :pending");
        otpUpdate.setParameter("expired", Status.EXPIRED);
        otpUpdate.setParameter("pharmacyId", pharmacy.getPharmacyId());
        otpUpdate.setParameter("pending", Status.PENDING);
        otpUpdate.executeUpdate();

        // Save new OTP
        PharmacyOtp newOtpObj = new PharmacyOtp();
        newOtpObj.setOtpCode(String.valueOf(newOtp));
        newOtpObj.setStatus(Status.PENDING);
        newOtpObj.setPurpose(Purpose.REGISTER);
        newOtpObj.setPharmacyId(pharmacy.getPharmacyId());
        newOtpObj.setCreatedAt(now);
        newOtpObj.setExpiresAt(expiry);
        session.save(newOtpObj);
        tx.commit();

        // Send OTP mail
        String subject = "Your new OTP code";
        String body = "Your new OTP is " + newOtp + ". Please use this to verify your account.";
        MailSend.sendInfo(email, subject, body);

        return "New OTP sent to your email.";
    }
// checking for duplicate Aadhar, GST,pharmacyEmail, OwnerEmail, PharmacyPhone, OwnerPhone
    public boolean isAadharExists(String aadhar) {
        session = SessionHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Pharmacy where aadhar = :aadhar");
        query.setParameter("aadhar", aadhar);
        query.setMaxResults(1);
        return query.uniqueResult() != null;
    }

    public boolean isGstExists(String gstNo) {
        session = SessionHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Pharmacy where gstNo = :gst");
        query.setParameter("gst", gstNo);
        query.setMaxResults(1);
        return query.uniqueResult() != null;
    }

    public boolean isEmailExist(String email) {
    	session = SessionHelper.getSessionFactory().openSession();
    	Query query = session.createQuery("from Pharmacy where email = :email");
    	query.setParameter("email", email);
    	query.setMaxResults(1);
    	return query.uniqueResult() != null;
    }
    public boolean isOwnerEmailExist(String ownerEmail) {
    	session = SessionHelper.getSessionFactory().openSession();
    	Query query = session.createQuery("from Pharmacy where ownerEmail = :ownerEmail");
    	query.setParameter("ownerEmail", ownerEmail);
    	query.setMaxResults(1);
    	return query.uniqueResult() != null;
    }
    public boolean isOwnerMobileExist(String ownerMobile) {
    	session = SessionHelper.getSessionFactory().openSession();
    	Query query = session.createQuery("from Pharmacy where ownerMobile = :ownerMobile");
    	query.setParameter("ownerMobile", ownerMobile);
    	query.setMaxResults(1);
    	return query.uniqueResult() != null;
    }
    public boolean isPharmacyMobileExist(String PharmacyMobile) {
    	session = SessionHelper.getSessionFactory().openSession();
    	Query query = session.createQuery("from Pharmacy where contactNo = :contactNo");
    	query.setParameter("contactNo", PharmacyMobile);
    	query.setMaxResults(1);
    	return query.uniqueResult() != null;
    }
	
	
}


