package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoHibernate;
import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.Account;
import com.example.models.User;
import com.example.services.UserService;
import com.example.utils.HibernateUtil;

public class Driver {
	
	public static void main(String args[]) {
		
		UserDao userDao = new UserDaoHibernate();
		
		UserService userService = new UserService(userDao);
		
		User u = userService.registerUser("Ethan", "McGill", "ethan@email.com", "emcgill", "password");
		
		System.out.println(u);
		
		AccountDao accountDao = new AccountDaoHibernate();
		
		Account checking = new Account("Checking", u);
		Account saving = new Account("Saving", u);
		
		accountDao.createAccount(checking);
		accountDao.createAccount(saving);
		
		Set<Account> accounts = new HashSet<>();
		accounts.add(checking);
		accounts.add(saving);
		
		u.setAccounts(accounts);
		
		userDao.updateUser(u);
		System.out.println(userDao.readUserByUsername("emcgill"));
		
		System.out.println("Get Ethans Accounts");
		System.out.println(accountDao.readAccountsByUser(u));
		
		com.example.models.Transaction t = new com.example.models.Transaction("deposit", 1000.00, saving);
		
		TransactionDao transactionDao = new TransactionDaoHibernate();
		
		transactionDao.createTransaction(t);
		
		saving.setToTransactions(List.of(t));
		
		accountDao.updateAccount(saving);
		
		System.out.println(accountDao.readAccountsByUser(u));
	}

}
