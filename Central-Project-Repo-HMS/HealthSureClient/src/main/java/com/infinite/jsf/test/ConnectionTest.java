package com.infinite.jsf.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.util.SessionHelper;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		SessionFactory sf=SessionHelper.getSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction trans=session.beginTransaction();
		
		System.out.println("Connection has been established: "+ session);
		
		trans.commit();
		
		session.close();

	}

}