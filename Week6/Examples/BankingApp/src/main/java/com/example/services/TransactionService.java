package com.example.services;

import java.util.List;

import com.example.dao.TransactionDao;
import com.example.exceptions.InvalidTransactionException;
import com.example.models.Account;
import com.example.models.Transaction;
import com.example.models.User;

public class TransactionService {
	
	private TransactionDao transactionDao;
	private AccountService accountService;
	private UserService userService;
	
	public TransactionService(TransactionDao transactionDao, AccountService accountService, UserService userService) {
		this.transactionDao = transactionDao;
		this.accountService = accountService;
		this.userService = userService;
	}
	
	public Account deposit(int accountNumber, double amount) {

		Account a = accountService.getAccountById(accountNumber);
		
		if(amount < 0) {
			throw new InvalidTransactionException();
		}
		
		a.setBalance(a.getBalance() + amount);
		
		Transaction t = new Transaction("DEPOSIT", amount, a);
		
		accountService.updateAccount(a);
		transactionDao.createTransaction(t);
		
		User u = a.getAccountHolder();
		List<Transaction> transactions = u.getTransactions();
		transactions.add(t);
		u.setTransactions(transactions);
		
		userService.updateUser(u);
		
		return a;
	}
	
	public Account withdraw(int accountNumber, double amount) {
		Account a = accountService.getAccountById(accountNumber);
		
		if(amount < 0) {
			throw new InvalidTransactionException();
		}
		
		if(a.getBalance() < amount) {
			throw new InvalidTransactionException();
		}
		
		a.setBalance(a.getBalance() - amount);
		
		Transaction t = new Transaction("WITHDRAW", amount, a);
		
		accountService.updateAccount(a);
		transactionDao.createTransaction(t);
		
		User u = a.getAccountHolder();
		List<Transaction> transactions = u.getTransactions();
		transactions.add(t);
		u.setTransactions(transactions);
		
		userService.updateUser(u);
		
		return a;
	}
	
	public Account transfer(int  accountA, int accountB, double amount) {
		Account a = accountService.getAccountById(accountA);
		Account b = accountService.getAccountById(accountB);
		
		if(amount < 0) {
			throw new InvalidTransactionException();
		}
		
		if(b.getBalance() < amount) {
			throw new InvalidTransactionException();
		}
		
		a.setBalance(a.getBalance() + amount);
		b.setBalance(b.getBalance() - amount);
		
		Transaction t = new Transaction("TRANSFER", amount, a, b);
		
		accountService.updateAccount(a);
		accountService.updateAccount(b);
		transactionDao.createTransaction(t);
		
		User uA = a.getAccountHolder();
		User uB = b.getAccountHolder();
		
		List<Transaction> transactionsA = uA.getTransactions();
		List<Transaction> transactionsB = uB.getTransactions();
		transactionsA.add(t);
		transactionsB.add(t);
		uA.setTransactions(transactionsA);
		uB.setTransactions(transactionsB);
		
		userService.updateUser(uA);
		userService.updateUser(uB);
		
		return a;
	}
	
	public List<Transaction> getUserTransactions(User u){
		return transactionDao.readTransactionByUser(u.getUserId());
	}

}
