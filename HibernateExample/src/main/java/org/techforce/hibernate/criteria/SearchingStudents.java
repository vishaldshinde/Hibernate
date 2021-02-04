package org.techforce.hibernate.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.Student;

public class SearchingStudents {

	public static void main(String[] args) {
		SearchingStudents ss = new SearchingStudents();
		
		//select * from student where fname like 'v%'
		ss.searchByFName();
		
		//select * from student where fname like 'v%' and branch is not null;
		ss.searchByFNameAndBranch();
		
		//select fname from student where fname like 'v%' and branch is not null;
		ss.searchFnameByFNameAndBranch();
		
		//select fname,lname from student where fname like 'v%' and branch is not null;
		ss.searchFnameLnameByFNameAndBranch();
		
		//select * from student order by fname;
		ss.orderByFName();
		
		HibernateUtil.shutdown();
	}

	@SuppressWarnings("deprecation")
	public void searchByFName() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.like("fname", "P%"));

		c.list().forEach(s -> System.out.println(s));
		
		session.getTransaction();
		session.close();
		

	}
	
	public void orderByFName() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Student.class);
		c.addOrder(Order.asc("fname"));

		c.list().forEach(s -> System.out.println(s));
		
		session.getTransaction();
		session.close();
		

	}
	
	public void searchByFNameAndBranch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Student.class);
		
		Criterion c1=Restrictions.like("fname", "V%");
		Criterion c2=Restrictions.isNotNull("branch");
		c.add(Restrictions.and(c1,c2));

		c.list().forEach(s -> System.out.println(s));
		
		session.getTransaction();
		session.close();
		

	}
	
	public void searchFnameByFNameAndBranch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Student.class);
		
		Criterion c1=Restrictions.like("fname", "V%");
		Criterion c2=Restrictions.isNotNull("branch");
		c.add(Restrictions.and(c1,c2));
		
		c.setProjection(Projections.property("fname"));
		
		c.list().forEach(s -> System.out.println(s));
		
		session.getTransaction();
		session.close();
		

	}
	
	public void searchFnameLnameByFNameAndBranch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Student.class);
		
		Criterion c1=Restrictions.like("fname", "V%");
		Criterion c2=Restrictions.isNotNull("branch");
		c.add(Restrictions.and(c1,c2));
		
		ProjectionList requiredcolumn=Projections.projectionList();
		requiredcolumn.add(Projections.property("fname"));
		requiredcolumn.add(Projections.property("lname"));
		
		c.setProjection(requiredcolumn);
		
		c.list().forEach(s -> System.out.println(s));
		
		session.getTransaction();
		session.close();
		

	}
}
