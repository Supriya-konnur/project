package com.xworkz.vaccinationapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class VaccinationRegistrationDAOImpl implements VaccinationRegistrationDAO{

	@Autowired
	private SessionFactory factory;
	@Override
	public String verifyEmail(String email) {
		Session session = null;
		try {
			session = factory.openSession();
			return (String) session.getNamedQuery("verifyEmail").setParameter("eid", email).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}
