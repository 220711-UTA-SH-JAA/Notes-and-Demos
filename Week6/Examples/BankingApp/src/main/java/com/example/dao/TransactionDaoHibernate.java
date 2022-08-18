package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.example.models.Transaction;
import com.example.utils.HibernateUtil;

public class TransactionDaoHibernate implements TransactionDao{

	/*
	 * Criteria API: a programatic way of fetching date from a relational database
	 * 
	 * Instead of writing query strings, you use methods on a Criteria object
	 * 
	 * You create the criteria with the session object similar to the queries
	 * 
	 */
	
	@Override
	public void createTransaction(Transaction t) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		org.hibernate.Transaction transaction = ses.beginTransaction();
		
		ses.save(t);
		
		transaction.commit();
		
	}

	@Override
	public Transaction readTransactionById(int id) {

		Session ses = HibernateUtil.getSession();
		
		Criteria c = ses.createCriteria(Transaction.class);
		c.add(Restrictions.eqOrIsNull("transactionId", id));
		
		List<Transaction> cList = c.list();
		
		return (Transaction) cList.get(0);
	}

	@Override
	public List<Transaction> readAllTransactions() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Transaction> transactions = ses.getSession().createQuery("from Transaction", Transaction.class).list();
		
		return transactions;
	}

	@Override
	public List<Transaction> readTransactionByUser(int id) {
		//To use the named query, we must get the session, then we call the named query from there
		
		Query q = HibernateUtil.getSession().createNamedQuery("getUsersTransactions");
		q.setParameter("id", id);
		
		return q.list();
	}

}
