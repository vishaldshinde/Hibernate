package org.techforce.hibernate.mapping_onetoone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Customer;
import org.techforce.hibernate.entities.Locker;

public class SaveCustomer {

	public static void main(String[] args) throws ParseException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Vishal");

		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date dob = (Date) format.parse("01/01/1988");
		customer.setDob(dob);

		Locker locker = new Locker();
		locker.setId(1);
		locker.setType("SIMPLE");
		locker.setRent(400.0);
		customer.setLocker(locker);

		session.save(customer);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
