package com.xworkz.enrollapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.enrollapp.entity.StudentEnrollEntity;
@Repository
public class StudentEnrollDAOImpl implements StudentEnrollDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean saveDetails(StudentEnrollEntity sEntity) {
		
		Session session =null;
		try {
			session =  factory.openSession();
			session.beginTransaction();
			session.save(sEntity);
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
