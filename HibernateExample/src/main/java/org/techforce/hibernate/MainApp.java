package org.techforce.hibernate;

import org.hibernate.Session;
import org.techforce.hibernate.entities.Student;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		
		   //Check database version 
		   String sql = "select version()";
		  
		  String result = (String) session.createNativeQuery(sql).getSingleResult();
		  System.out.println(result);
		 

		
		session.close();

		HibernateUtil.shutdown();
	}

}
