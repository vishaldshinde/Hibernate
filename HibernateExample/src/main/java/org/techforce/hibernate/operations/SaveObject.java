package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class SaveObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//saving an object into database
		Student s=new Student(1, "Vishal", "Shinde", "Electrical");
		
		System.out.println("Save method returns:"+session.save(s));
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
		

	}

}
