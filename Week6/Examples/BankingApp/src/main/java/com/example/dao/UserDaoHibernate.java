package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDaoHibernate implements UserDao{
	
	/*
	 * Native SQL Query
	 * A query that allows you to write database specific queries
	 * 
	 * It is not recommended to use this, because it will tightly couple your code to a database
	 * 
	 * To create a native query you will use Session.createNativeQuery()
	 * 
	 */

	@Override
	public void createUser(User u) {
		//Hibernate has built in crud functionality, so we can create a user very easily
		
		//Get our session
		Session ses = HibernateUtil.getSession();
		
		//Start a transaction
		Transaction transaction = ses.beginTransaction();
		
		//Save the user
		ses.save(u);
		
		//Commit the user to the database
		transaction.commit();
		
	}

	@Override
	public User readUserByUsername(String username) {
		//Native SQL query to read by username
		
		Session ses = HibernateUtil.getSession();
		
		//User u = ses.createNativeQuery("select * from users where username ='" + username + "'").;
		
		User u = ses.createQuery("from User where username=:username", User.class).setParameter("username", username).uniqueResult();
		
		System.out.println("In the dao: " + u);
		
		return u;
	}

	@Override
	public List<User> readAllUsers() {

		//Another native sql query
		Session ses = HibernateUtil.getSession();
		
		List<User> users = ses.createNativeQuery("select * from users").list();
		
		return users;
	}

	@Override
	public void updateUser(User u) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.update(u);
		
		transaction.commit();
		
	}

	@Override
	public boolean deleteUser(User u) {

		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.delete(u);
		
		transaction.commit();
		
		return true;
	}

}
