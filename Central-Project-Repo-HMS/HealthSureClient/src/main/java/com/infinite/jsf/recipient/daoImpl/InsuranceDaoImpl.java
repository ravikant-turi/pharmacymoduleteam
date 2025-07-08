package com.infinite.jsf.recipient.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.insurance.model.SubscriptionStatus;
import com.infinite.jsf.insurance.model.SubscriptionType;
import com.infinite.jsf.recipient.dao.InsuranceDao;
import com.infinite.jsf.recipient.model.PatientInsuranceDetails;

public class InsuranceDaoImpl implements InsuranceDao{

	static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Override
	public List<PatientInsuranceDetails> showInsuranceOfRecipient(String recipientId) {
		return fetchInsuranceByStatus(recipientId, null); // Show all (no filter)
	}

	@Override
	public List<PatientInsuranceDetails> showActiveInsuranceOfRecipient(String recipientId) {
		return fetchInsuranceByStatus(recipientId, true); // Only active
	}

	@Override
	public List<PatientInsuranceDetails> showExpiredInsuranceOfRecipient(String recipientId) {
		return fetchInsuranceByStatus(recipientId, false); // Only expired
	}

	// 🔥 Shared logic method with status filter
	private List<PatientInsuranceDetails> fetchInsuranceByStatus(String recipientId, Boolean activeOnly) {
		Session session = sessionFactory.openSession();
		session.clear();

		Query query = session.getNamedQuery("PatientInsuranceDetails.findByRecipientId");
		query.setParameter("hId", recipientId);
		List<Object[]> results = query.list();
		List<PatientInsuranceDetails> detailsList = new ArrayList<>();
		Date today = new Date();

		for (Object[] row : results) {
			Date coverageEndDate = (Date) row[7];

			// ✅ Apply filter if activeOnly is not null
			if (activeOnly != null) {
				boolean isActive = (coverageEndDate == null || !coverageEndDate.before(today));
				if (activeOnly != isActive)
					continue; // Skip if doesn't match required status
			}

			PatientInsuranceDetails details = new PatientInsuranceDetails();
			details.setSubscribeId((String) row[0]);
			details.sethId((String) row[1]);
			details.setPatientName((String) row[2]);
			details.setCompanyName((String) row[3]);
			details.setPlanName((String) row[4]);
			details.setEnrollmentDate((Date) row[5]);
			details.setCoverageStartDate((Date) row[6]);
			details.setCoverageEndDate(coverageEndDate);

			SubscriptionStatus status = SubscriptionStatus.valueOf(((String) row[8]).toUpperCase());
			SubscriptionType type = SubscriptionType.valueOf(((String) row[9]).toUpperCase());

			details.setCoverageStatus(status);
			details.setCoverageType(type);
			details.setCoverageLimit((Double) row[10]);
			details.setRemaining((Double) row[11]);
			details.setClaimed((Double) row[12]);
			details.setLastClaimDate((Date) row[13]);

			if (type == SubscriptionType.FAMILY) {
				Query memberQuery = session.getNamedQuery("SubscribedMember.findBySubscribeId");
				memberQuery.setParameter("subscribeId", details.getSubscribeId());

				List<SubscribedMember> memberRows = memberQuery.list();
				List<SubscribedMember> members = new ArrayList<>();

				for (SubscribedMember member : memberRows) {
					Subscribe subscribe = new Subscribe();
					subscribe.setSubscribeId(details.getSubscribeId());
					member.setSubscribe(subscribe);
					members.add(member);
				}
				details.setSubscribedMembers(members);
			} else {
				details.setSubscribedMembers(new ArrayList<>());
			}

			detailsList.add(details);
		}

		session.close();
		return detailsList;
	}
}
