package org.techforce.hibernate.operations;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class GetObject {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Operation
		Student s=session.get(Student.class, 1);//cache miss
		System.out.println("Get student with ID -1 :"+s);
		
		Student sn=session.get(Student.class, 1);//cache hit
		System.out.println("Getting from session levele cache(first level), S1:"+sn);
		
		session.evict(sn);//Removes the entity object from session cache. 

		//evict will remove only the given object, whereas clear() will remove all the objects available in the cache
		
		Student s1=session.get(Student.class, 1);
		System.out.println(" S1:"+s1);//cache miss
		
		s.setBranch("Computer Engineering");
		
		System.out.println("Updated student :"+s);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
		
		

	}

}
