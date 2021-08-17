package com.xworkz.vaccinationapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccinationapp.entity.VaccinationEntity;
@Repository
public class VaccinationDAOImpl implements VaccinationDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean saveDetails(VaccinationEntity vEntity) {

		Session session =null;
		try {
			session =  factory.openSession();
			session.beginTransaction();
			session.save(vEntity);
			session.getTransaction().commit();
			return true;
			
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return false;
	}

}
