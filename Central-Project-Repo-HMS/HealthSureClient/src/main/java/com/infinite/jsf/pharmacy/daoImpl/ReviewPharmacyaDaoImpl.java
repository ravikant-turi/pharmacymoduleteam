package com.infinite.jsf.pharmacy.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.pharmacy.model.Pharmacy;
import com.infinite.jsf.pharmacy.dao.ReviewPharmacyaDao;
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

}
