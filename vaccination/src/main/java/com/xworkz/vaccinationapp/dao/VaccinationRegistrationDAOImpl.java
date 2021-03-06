package com.xworkz.vaccinationapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccinationapp.entity.VaccinationEntity;
@Repository
public class VaccinationRegistrationDAOImpl implements VaccinationRegistrationDAO{

	@Autowired
	private SessionFactory factory;
	@Override
	public VaccinationEntity emailVerification(String email) {
		Session session = null;
		try {
			session = factory.openSession();
			return (VaccinationEntity) session.getNamedQuery("emailVerification").setParameter("eId", email).uniqueResult();
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
