package com.infinite.jsf.recipient.daoImpl;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.infinite.jsf.provider.model.Doctor;
import com.infinite.jsf.recipient.dao.SearchDoctorDao;
import com.infinite.jsf.util.SessionHelper;

public class SearchDoctorDaoImpl implements SearchDoctorDao {

    private SessionFactory sessionFactory;

    public SearchDoctorDaoImpl() {
        this.sessionFactory = SessionHelper.getSessionFactory(); // You can inject if using DI
    }

    @Override
    public List<Doctor> searchDoctors(String searchBy, String value) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Doctor.class, "doctor");

        if ("name".equalsIgnoreCase(searchBy)) {
            criteria.add(Restrictions.ilike("doctorName", "%" + value + "%"));
        } else if ("specialization".equalsIgnoreCase(searchBy)) {
            criteria.add(Restrictions.ilike("specialization", "%" + value + "%"));
        } else if ("address".equalsIgnoreCase(searchBy)) {
            criteria.add(Restrictions.ilike("address", "%" + value + "%"));
        }

        List<Doctor> doctors = criteria.list();
        session.close();
        return doctors != null ? doctors : new ArrayList<>();
    }
}
