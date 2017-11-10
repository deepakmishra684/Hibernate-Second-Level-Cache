package com.depak.hibernate.cache.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.depak.hibernate.cache.model.Employee;
import com.depak.hibernate.cache.util.HibernateUtil;

public class InsertManager {
	public static void main(String[] args) {
		// Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Save Employee 1
		Employee emp = new Employee("Deepak", 100);
		session.save(emp);

		// Save Employee 2
		emp = new Employee("Manish", 200);
		session.save(emp);

		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
