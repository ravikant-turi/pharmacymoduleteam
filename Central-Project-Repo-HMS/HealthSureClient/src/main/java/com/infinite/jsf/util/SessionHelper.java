package com.infinite.jsf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHelper {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration().configure(); // Loads hibernate.cfg.xml
            sessionFactory = config.buildSessionFactory();
            System.out.println("✅ Hibernate SessionFactory initialized.");
        } catch (Throwable ex) {
            System.err.println("❌ SessionFactory creation failed: " + ex);
            ex.printStackTrace(); // Print full stack
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
