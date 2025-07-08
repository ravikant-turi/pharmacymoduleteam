package com.infinite.jsf.recipient.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infinite.jsf.recipient.dao.SubscriptionDAO;
import com.infinite.jsf.recipient.model.Subscription;
import com.infinite.jsf.util.SessionHelper;

public class SubscriptionDAOImpl implements SubscriptionDAO {

    SessionFactory sf;

    public SubscriptionDAOImpl() {
        sf = SessionHelper.getSessionFactory();
    }

    @Override
    public List<Subscription> getAllByRecipientId(String recipientId) {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Subscription WHERE recipient.hId = :recipientId ORDER BY subscribeDate DESC");
        query.setParameter("recipientId", recipientId);
        return query.list();
    }

    @Override
    public List<Subscription> getActiveByRecipientId(String recipientId) {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Subscription WHERE recipient.hId = :recipientId AND status = 'Active' ORDER BY subscribeDate DESC");
        query.setParameter("recipientId", recipientId);
        return query.list();
    }

    @Override
    public List<Subscription> getExpiredByRecipientId(String recipientId) {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Subscription WHERE recipient.hId = :recipientId AND status = 'Expired' ORDER BY subscribeDate DESC");
        query.setParameter("recipientId", recipientId);
        return query.list();
    }

}
