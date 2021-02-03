package org.techforce.hibernate.mapping_manytomany;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Account;
import org.techforce.hibernate.entities.NCustomer;

public class SaveCustmore {

	public static void main(String[] args) throws ParseException {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Account a1=new Account();
		a1.setAccount_no(Long.valueOf(3491l));
		a1.setAccount_status("OPEN");
		a1.setAccount_type("CURENT");
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date opening_date = (Date) format.parse("18/08/2020");
		a1.setOpening_date(opening_date);
		
		Account a2=new Account();
		a2.setAccount_no(Long.valueOf(3492l));
		a2.setAccount_status("OPEN");
		a2.setAccount_type("SAVING");
		format = new SimpleDateFormat("mm/dd/yyyy");
		opening_date = (Date) format.parse("22/06/2020");
		a2.setOpening_date(opening_date);
		
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		
		NCustomer c=new NCustomer();
		c.setAccounts(accounts);
		c.setAddress("Rajyog Park A");
		c.setCust_id(104);
		c.setName("Prajwal Shinde");
		c.setPhoneno("7720013497");
		
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
	}

}
