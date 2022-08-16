package com.example.dao;

import java.util.List;

import com.example.models.Account;

public interface AccountDao {
	
	void createAccount(Account a);
	
	Account readAccountByNumber(int id);
	
	List<Account> readAllAccounts();
	
	void updateAccount(Account a);
	
	boolean deleteAccount(Account a);

}
