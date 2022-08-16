package com.example.services;

import com.example.models.Account;

public class TransactionService {
	
	public Account deposit(Account a, double amount) {
		a.setBalance(a.getBalance() + amount);
		
		return a;
	}
	
	public Account withdraw(Account a, double amount) {
		a.setBalance(a.getBalance() - amount);
		return a;
	}
	
	public Account transfer(Account a, Account b, double amount) {
		a.setBalance(a.getBalance() - amount);
		b.setBalance(b.getBalance() + amount);
		return a;
	}

}
