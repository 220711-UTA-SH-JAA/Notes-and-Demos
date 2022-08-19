package com.example.services;

import java.util.List;

import com.example.dao.AccountDao;
import com.example.models.Account;
import com.example.models.User;

public class AccountService {
	
	private AccountDao accountDao;
	public AccountService(AccountDao accountDao){
			this.accountDao = accountDao;
	}
	
	public Account registerAccount(String type, User u) {
		
		Account a = new Account(type, u);
		
		int id = accountDao.createAccount(a);
		
		return accountDao.readAccountByNumber(id);
		
	}
	
	public Account getAccountById(int id) {
		return accountDao.readAccountByNumber(id);
	}
	
	public void updateAccount(Account a) {
		accountDao.updateAccount(a);
	}
	
	public List<Account> getAccountsByUser(User u){
		return accountDao.readAccountsByUser(u);
	}

}
