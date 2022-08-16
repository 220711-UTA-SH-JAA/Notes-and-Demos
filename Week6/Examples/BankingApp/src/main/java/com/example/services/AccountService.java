package com.example.services;

import com.example.models.Account;
import com.example.models.User;

public class AccountService {
	
	//private AccountDao accountDao;
	/*	public AccountService(AccountDao accountDao){
	 * 		this.accountDao = accountDao;
	 * 	}
	 */
	
	public Account registerAccount(String type, User u) {
		return new Account(type, u);
	}

}
