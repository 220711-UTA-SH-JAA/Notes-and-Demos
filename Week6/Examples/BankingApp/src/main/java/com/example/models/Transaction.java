package com.example.models;

public class Transaction {
	
	private Integer transactionId;
	private String type;
	private Double amount;
	private Account to;
	//I am about to break the rules and set this to null
	private Account from;
	
	public Transaction() {
		super();
	}
	
	//A constructor specifically for none transfer transactions
	public Transaction(String type, Double amount, Account to) {
		this.type = type;
		this.amount = amount;
		this.to = to;
		this.from = null;
	}
	
	//A constructor specifically for transfers
	public Transaction(String type, Double amount, Account to, Account from) {
		this.type = type;
		this.amount = amount;
		this.to = to;
		this.from = from;
	}
	
	public Transaction(Integer transactionId, String type, Double amount, Account to, Account from) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.amount = amount;
		this.to = to;
		this.from = from;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", amount=" + amount + ", to=" + to
				+ ", from=" + from + "]";
	}
}
