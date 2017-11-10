package com.depak.hibernate.cache.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.depak.hibernate.cache.model.Employee;
import com.depak.hibernate.cache.util.HibernateUtil;

public class LoadManager {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, new Long(1));
		System.out.println(employee.toString());
		tx.commit();
		session.close();

		System.out.println("**************************************************************");
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		employee = (Employee) session.get(Employee.class, new Long(1));
		System.out.println(employee.toString());
		tx.commit();
		session.close();
		
		System.out.println("****************************************************************");

		/*session = sessionFactory.openSession();
		employee= (Employee) session.load(Employee.class, new Long(1));
		session.close();// after closing session we are updating record
		*/
		employee.setName("manohar");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(employee);
		System.out.println(employee.toString());
		tx.commit();
		session.close();
		System.out.println("Done");
	}

}
