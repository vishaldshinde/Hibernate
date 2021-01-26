package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class LoadObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		//Operation
		Student s=session.load(Student.class,1);
		
		System.out.println("Load student with Id:"+s);
		
		s.setBranch("Information Technology");
		
		System.out.println("Update student with Id:"+s);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
	}

}
