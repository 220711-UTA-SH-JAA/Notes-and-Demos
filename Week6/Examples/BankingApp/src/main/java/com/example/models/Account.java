package com.example.models;

import java.util.HashSet;
import java.util.Set;

public class Account {
	
	private Integer accountId;
	private String type;
	private User accountHolder;
	private Double balance;
	private Set<Transaction> transactions;
	
	public Account() {
		super();
		this.transactions = new HashSet<>();
	}
	
	public Account(String type, User accountHolder) {
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
		this.transactions = new HashSet<>();
	}

	public Account(Integer accountId, String type, User accountHolder, Double balance, Set<Transaction> transactions) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.transactions = transactions;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(User accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", accountHolder=" + accountHolder + ", balance="
				+ balance + "]";
	}
}
