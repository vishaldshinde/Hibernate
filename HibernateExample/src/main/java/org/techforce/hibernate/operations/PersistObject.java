package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class PersistObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Operation
		Student s=new Student(2, "Hema", "Shinde", "Interior Designer");

		session.persist(s);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
		
		
	}

}
