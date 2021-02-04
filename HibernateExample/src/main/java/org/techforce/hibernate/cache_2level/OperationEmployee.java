package org.techforce.hibernate.cache_2level;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;

public class OperationEmployee {

	public static void main(String[] args) {

		// Save Employee
		Session session1=HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		
		CacheEmployee c_emp=new CacheEmployee();
		c_emp.setEmp_id(100);
		c_emp.setName("Vishal Shinde");
		c_emp.setSalary(50000.0);
		
		session1.save(c_emp);
		
		CacheEmployee e1=session1.get(CacheEmployee.class, 100);//cache hit L1
		
		System.out.println("e1:"+e1);
		
		session1.getTransaction().commit();
		
		Session session2=HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		CacheEmployee e2=session2.get(CacheEmployee.class, 100);//cache miss L1-hit L2
		System.out.println("e2:"+e2);
		CacheEmployee e3=session2.get(CacheEmployee.class, 100);//cache hit L1
		System.out.println("e3:"+e3);
		
		session2.clear();//removing all object from l1 cache
		
		CacheEmployee e4=session2.get(CacheEmployee.class, 100);//cache miss L1-hit L2
		System.out.println("e4:"+e4);
		
		CacheEmployee e5=session2.get(CacheEmployee.class, 100);//cache hit L1
		System.out.println("e5:"+e5);
		
		CacheEmployee e6=session2.get(CacheEmployee.class, 200);//cache miss L1 and L2
		System.out.println("e6:"+e6);

		session2.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
