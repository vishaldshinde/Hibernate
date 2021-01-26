package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class RefreshObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Student s=session.get(Student.class, 1);
		
		System.out.println("1:Get object:" + s);
		
		  session.getTransaction().commit(); session.close();
		  
		  Session session1 = HibernateUtil.getSessionFactory().openSession();
		  
		  session1.beginTransaction();
		 
		System.out.println("2: Delaying programm by 50000 ms, please execute below query during this delay: ");
		System.out.println("update STUDENT set BRANCH=\"Informatio Tech\" where SID=1");

		try {
			Thread.sleep(50000);
		} catch (Exception e) {
			System.out.println("Thread exceeption:");
		}

		
		session1.refresh(s);
		System.out.println("3:Refreshed object:"+s);

		session1.getTransaction().commit();
		session1.close();

		HibernateUtil.shutdown();

	}

}
