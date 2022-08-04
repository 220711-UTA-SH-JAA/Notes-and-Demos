package com.example.models;

public class Account {
	
	int accountId;
	String accountType;
	double accountBalance;
	int accountHolder;
	
	public Account() {
		
	}
	
	public Account(int id, String type, double balance, int holder) {
		this.accountId = id;
		this.accountType = type;
		this.accountBalance = balance;
		this.accountHolder = holder;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(int accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", accountHolder=" + accountHolder + "]";
	}
}
