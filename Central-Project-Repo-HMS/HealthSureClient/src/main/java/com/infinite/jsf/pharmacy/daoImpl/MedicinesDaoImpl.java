package com.infinite.jsf.pharmacy.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.infinite.jsf.pharmacy.dao.MedicinesDao;
import com.infinite.jsf.pharmacy.model.Medicines;
import com.infinite.jsf.util.SessionHelper;

public class MedicinesDaoImpl implements MedicinesDao {

    @Override
    public List<Medicines> getMedicinesByPharmacyId(String pharmacyId) {
        Session session = SessionHelper.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Medicines where pharmacy.pharmacyId = :pharmacyId");
            query.setParameter("pharmacyId", pharmacyId);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Medicines> searchMedicinesStartingWith(String name, String pharmacyId) {
        Session session = SessionHelper.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Medicines where lower(medicineName) like :name and pharmacy.pharmacyId = :pharmacyId");
            query.setParameter("name", name.toLowerCase() + "%");
            query.setParameter("pharmacyId", pharmacyId);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Medicines> searchMedicinesContaining(String name, String pharmacyId) {
        Session session = SessionHelper.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Medicines where lower(medicineName) like :name and pharmacy.pharmacyId = :pharmacyId");
            query.setParameter("name", "%" + name.toLowerCase() + "%");
            query.setParameter("pharmacyId", pharmacyId);
            return query.list();
        } finally {
            session.close();
        }
    }
}
