package org.techforce.hibernate.inheritance_single_table;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;

public class SaveAccount {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		// inserting only parrent account also works
		Account account = new Account();
		account.setAccount_no(23547l);
		account.setAccount_status("Active");
		account.setBalance(200.0);
		account.setOpen_date(null);
		session.save(account);

		// inserting child saving account
		SavingAccount s_account = new SavingAccount();
		s_account.setAccount_no(23548l);
		s_account.setAccount_status("Active");
		s_account.setBalance(400.0);
		s_account.setOpen_date(null);
		s_account.setMinimum_balance(100.0);
		session.save(s_account);

		// inserting child saving account
		CurrentAccount c_account = new CurrentAccount();
		c_account.setAccount_no(23549l);
		c_account.setAccount_status("Active");
		c_account.setBalance(400.0);
		c_account.setOpen_date(null);
		c_account.setOverDraftAmount(700.0);
		session.save(c_account);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
	}

}
