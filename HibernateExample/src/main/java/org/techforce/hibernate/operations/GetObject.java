package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class GetObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Operation
		Student s=session.get(Student.class, 1);
		System.out.println("Get student with ID -1 :"+s);
		
		
		
		s.setBranch("Computer Engineering");
		
		System.out.println("Updated student :"+s);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
		
		

	}

}
