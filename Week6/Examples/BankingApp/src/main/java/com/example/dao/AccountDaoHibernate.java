package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Account;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class AccountDaoHibernate implements AccountDao{

	@Override
	public void createAccount(Account a) {
		//Builtin save method from hibernate
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.save(a);
		
		transaction.commit();
		
	}

	@Override
	public Account readAccountByNumber(int id) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		/* Is Hibernate query language
		 * It is an object oriented query language, so we are querying based off of the objects, rather than the database
		 * table
		 * 
		 * Hibernate will automatically take this HQL and convert it to the correct SQL language based on the dialect
		 * - We can change the dialect, without having to rewrite our queries
		 */
		
		//Account is the actual class we are querying, and accountId is the property on the Account class
		return ses.createQuery("from Account where accountId=:id", Account.class).setParameter(0, id).uniqueResult();
	}

	@Override
	public List<Account> readAllAccounts() {
		//HQL
		return HibernateUtil.getSession().createQuery("from Account", Account.class).list();
	}

	@Override
	public void updateAccount(Account a) {
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.update(a);
		
		transaction.commit();
		
	}

	@Override
	public boolean deleteAccount(Account a) {
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.delete(a);
		
		transaction.commit();
		return true;
	}

	@Override
	public List<Account> readAccountsByUser(User u) {
		
		//Create an HQL query
		Session ses = HibernateUtil.getSession();
		
		List<Account> userAccounts = ses.createQuery("from Account where accountHolder=:user", Account.class).setParameter("user", u)
				.list();
		
		return userAccounts;
	}
	
	

}
