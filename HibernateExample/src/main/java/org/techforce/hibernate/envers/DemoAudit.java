package org.techforce.hibernate.envers;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;

public class DemoAudit {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Login login=new Login();
		login.setId(1001);
		login.setName("Vishal");
		login.setPassword("password");
		
		session.save(login);
		
		//session.evict(login);
		
		Login login1=session.get(Login.class, 1001);
		login1.setName("Vishal Shinde");
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
