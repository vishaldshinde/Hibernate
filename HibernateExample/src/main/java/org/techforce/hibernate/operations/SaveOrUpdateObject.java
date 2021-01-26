package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class SaveOrUpdateObject {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//for update operation
		Student s1=new Student(1,"Vishal","Shinde","Computer");
		session.saveOrUpdate(s1);
		
		//for save operation
		Student s2=new Student(3,"Prajwal","Shinde","Medical");
		session.saveOrUpdate(s2);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
