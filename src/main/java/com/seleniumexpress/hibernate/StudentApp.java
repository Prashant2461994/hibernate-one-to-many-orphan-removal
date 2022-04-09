package com.seleniumexpress.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seleniumexpress.models.Order;
import com.seleniumexpress.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class StudentApp {

	private static Session session = null;

	public static void main(String[] args) {

		// 1. create configuration
		// 2. create session factory
		// 3. initialize the session object

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		Order order = session.get(Order.class, 1);
		session.delete(order);

		transaction.commit();

		session.close();
		sessionFactory.close();

	}

}
