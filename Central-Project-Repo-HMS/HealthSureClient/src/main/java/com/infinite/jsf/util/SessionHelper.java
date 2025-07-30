package com.infinite.jsf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;

/**
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 *
 * Utility class for managing Hibernate SessionFactory.
 *
 * <p>This class initializes a singleton instance of SessionFactory using the 
 * configuration provided in the `hibernate.cfg.xml` file. It provides a 
 * static method to access the SessionFactory throughout the application.</p>
 *
 * <p>Logging is handled using Log4j to track the initialization process and 
 * capture any errors during SessionFactory creation.</p>
 *
 * @author Infinite Computer Solution
 * @version 1.0
 */
public class SessionHelper {
    private static final Logger logger = Logger.getLogger(SessionHelper.class);
    private static final SessionFactory sessionFactory;

    // Static block to initialize the SessionFactory when the class is loaded
    static {
        try {
            Configuration config = new Configuration().configure(); // Loads hibernate.cfg.xml
            sessionFactory = config.buildSessionFactory();
            if (logger.isDebugEnabled()) {
                logger.debug("Hibernate configuration loaded and SessionFactory built successfully.");
            }
            logger.info("Hibernate SessionFactory initialized.");
        } catch (Throwable ex) {
            logger.error("SessionFactory creation failed: ", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Returns the singleton instance of Hibernate SessionFactory.
     * 
     * @return SessionFactory instance for database operations
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
