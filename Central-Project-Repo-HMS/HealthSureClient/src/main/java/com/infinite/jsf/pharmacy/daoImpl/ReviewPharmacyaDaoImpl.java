package com.infinite.jsf.pharmacy.daoImpl;

import java.util.List;

import javax.management.j2ee.statistics.JavaMailStats;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.pharmacy.model.Pharmacy;
import com.infinite.jsf.pharmacy.dao.ReviewPharmacyaDao;
import com.infinite.jsf.util.MailSend;
import com.infinite.jsf.util.SessionHelper;

public class ReviewPharmacyaDaoImpl implements ReviewPharmacyaDao {

	static SessionFactory factory;
	static Session session;

	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public List<Pharmacy> reviewPharmacyDetails() {

		List<Pharmacy> pharmacies;

		session = factory.openSession();

		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Pharmacy");
		pharmacies = query.list();
		trans.commit();
		session.close();

		return pharmacies;

	}

	@Override
	public Pharmacy searchPharmacyById(String pharmacyId) {
		session = factory.openSession();

		Transaction trans = session.beginTransaction();
		
		Pharmacy pharmacy=(Pharmacy) session.get(Pharmacy.class, pharmacyId);
		
		trans.commit();
		session.close();

		return pharmacy;

	}

	@Override
	public String updatePharmacyStatus(Pharmacy pharmacy) {
	    session = factory.openSession();
	    Transaction trans = session.beginTransaction();

	    String pharmacyId = pharmacy.getPharmacyId(); 
	  

	    pharmacy.setStatus("ACCEPTED");
	    session.update(pharmacy);


	    String email = pharmacy.getEmail();

	    MailSend.sendInfo(email, "PHARMACY STATUS : ACCETPED " ,"\n Congratulations !!  Your pharmacy s has been ACCPTED \n\n ADMIN : \n RAVIKANT TURI");

	    trans.commit();
	    session.close();
	    return "updated";
	}


}
