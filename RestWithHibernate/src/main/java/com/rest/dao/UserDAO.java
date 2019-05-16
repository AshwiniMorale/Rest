package com.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.rest.beans.User;


@Component
public class UserDAO {


	public List list() {
		System.out.println("dao list() called");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List list = null;

		String hql = "From User";
		Query query = session.createQuery(hql);
		list = query.list();
		
		tx.commit();
		session.close();
		return list;
	}

	/**
	 * Return customer object for given id from dummy database. If customer is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            customer id
	 * @return customer object for given id
	 */
	public User getUser(Integer id) {
		System.out.println("dao getUser() called");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list = null;

		String hql = "From User WHERE ID = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		list = query.list();
		
		tx.commit();
		session.close();

		for (User user : list) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Create new customer in dummy database. Updates the id and insert new
	 * customer in list.
	 * 
	 * @param customer
	 *            Customer object
	 * @return customer object with updated id
	 */
	public User create(User user) {
		System.out.println("dao create() called");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

		return user;
	}

	/**
	 * Delete the customer object from dummy database. If customer not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the customer id
	 * @return id of deleted customer object
	 */
	public Integer delete(Integer id) {

		
		System.out.println("dao delete() called");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(id);
		session.delete(user);
		tx.commit();
		session.close();
		return id;
	}

	/**
	 * Update the customer object for given id in dummy database. If customer
	 * not exists, returns null
	 * 
	 * @param id
	 * @param customer
	 * @return customer object with id
	 */
	public User update(Integer id, User user) {

		
		System.out.println("dao Update() called");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		user.setId(id);
		session. update(user);
		tx.commit();
		session.close();
		return user;

	}

}