package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.exceptions.OverDraftException;
import com.example.models.Account;
import com.example.models.Customer;

public class AccountService {
	
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public Account createAccount(Customer c, String type, double balance) {
		
		Account a = new Account(0, type, balance, c.getCustomerId());
		
		accountDao.createAccount(a);
		
		return a;
		
	}
	
	public List<Account> getCustomerAccounts(Customer c){
		List<Account> allAccounts = accountDao.readAllAcounts();
		List<Account> customerAccounts = new ArrayList<>();
		
		for(Account a: allAccounts) {
			if(a.getAccountHolder() == c.getCustomerId()) {
				customerAccounts.add(a);
			}
		}
		
		return customerAccounts;
	}
	
	public Account getAccountByNumber(int accountNumber) {
		List<Account> allAccounts = accountDao.readAllAcounts();
		for(Account a: allAccounts) {
			if(a.getAccountId() == accountNumber) {
				return a;
			}
		}
		
		return null;
	}
	
	public void deposit(Account a, double amount) {
		a.setAccountBalance(a.getAccountBalance() + amount);
		accountDao.updateAccount(a);
	}
	
	public void withdraw(Account a, double amount) {
		//You would want to make sure the amount being withdrawed is not more than you have
		if(amount > a.getAccountBalance()) {
			throw new OverDraftException();
		}
		
		a.setAccountBalance(a.getAccountBalance() - amount);
		accountDao.updateAccount(a);
	}
	
	public void transfer(Account from, Account to, double amount) {
		//throw an exception if theres not enough money, and stop transaction before transfering
		withdraw(from, amount);
		deposit(to, amount);
	}

}
