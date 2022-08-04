package com.example.dao;

import java.util.List;

import com.example.models.Account;

public interface AccountDao {

	void createAccount(Account a);
	
	List<Account> readAllAcounts();
	
	void updateAccount(Account a);
	
	void deleteAccount(int id);
	
}
