package org.techforce.hibernate.mapping_manytoone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Address;
import org.techforce.hibernate.entities.Employee;

public class SaveEmployee {

	public static void main(String[] args) throws ParseException {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address address=new Address();
		address.setAddressId(102);
		address.setAddressLine("Saptsur Niwas, Chopdaj");
		address.setDistrict("Pune");
		address.setState("Maharashtra");
		address.setPinCode(412361);
		
		Employee employee=new Employee();
		employee.setEmpId(88964);
		employee.setAddress(address);
		employee.setName("Dilip Shinde");
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date dob = (Date) format.parse("18/06/1961");
		employee.setDob(dob);
		employee.setPhoneNo("7720013497");
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
	}

}
