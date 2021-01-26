package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class MergeObject {

	public static void main(String[] args) {
		
		Session session1=HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		
		Student s=new Student(4,"Vanshika","Shinde","Engineer");
		
		System.out.println("Saved Object:"+session1.save(s));
		
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("Student Object is now in detached state..");
		
		s.setBranch("Civil Egineering");
		//s.setId(5); //it will insert new row
		
		Session session2=HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		System.out.println("Merged Object:"+session2.merge(s));
		
		session2.getTransaction().commit();
		session2.close();
		
		HibernateUtil.shutdown();

	}

}
