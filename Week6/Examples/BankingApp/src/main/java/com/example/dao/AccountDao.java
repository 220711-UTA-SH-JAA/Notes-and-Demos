package com.example.dao;

import java.util.List;

import com.example.models.Account;
import com.example.models.User;

public interface AccountDao {
	
	void createAccount(Account a);
	
	Account readAccountByNumber(int id);
	
	List<Account> readAllAccounts();
	
	void updateAccount(Account a);
	
	boolean deleteAccount(Account a);
	
	List<Account> readAccountsByUser(User u);

}
