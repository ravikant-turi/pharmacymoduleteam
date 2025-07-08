package com.infinite.jsf.pharmacy.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.infinite.jsf.pharmacy.dao.EquipmentDao;
import com.infinite.jsf.pharmacy.model.Equipment;
import com.infinite.jsf.util.SessionHelper;

public class EquipmentDaoImpl implements EquipmentDao {

	@Override
	public List<Equipment> getEquipmentByPharmacyId(String pharmacyId) {
        Session session = SessionHelper.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Equipment where pharmacy.pharmacyId = :pharmacyId");
            query.setParameter("pharmacyId", pharmacyId);
            return query.list();
        } finally {
            session.close();
        }
	}

	@Override
	public List<Equipment> searchEquipmentStartingWith(String name, String pharmacyId) {
		 Session session = SessionHelper.getSessionFactory().openSession();
	        try {
	            Query query = session.createQuery("from Equipment where lower(equipmentName) like :name and pharmacy.pharmacyId = :pharmacyId");
	            query.setParameter("name", name.toLowerCase() + "%");
	            query.setParameter("pharmacyId", pharmacyId);
	            return query.list();
	        } finally {
	            session.close();
	        }
	}

	@Override
	public List<Equipment> searchEquipmentContaining(String name, String pharmacyId) {
		 Session session = SessionHelper.getSessionFactory().openSession();
	        try {
	            Query query = session.createQuery("from Equipment where lower(equipmentName) like :name and pharmacy.pharmacyId = :pharmacyId");
	            query.setParameter("name", "%" + name.toLowerCase() + "%");
	            query.setParameter("pharmacyId", pharmacyId);
	            return query.list();
	        } finally {
	            session.close();
	        }
	}

}
