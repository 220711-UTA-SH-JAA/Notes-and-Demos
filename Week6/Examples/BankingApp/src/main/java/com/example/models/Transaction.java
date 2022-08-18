package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@Column(name="transaction_type")
	private String type;
	
	@Column(name="transaction_amount")
	private Double amount;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="incoming_account")
	private Account to;
	//I am about to break the rules and set this to null
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="outgoing_account", nullable=true)
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
		
		String fromAcc = null;
		
		if(from != null) {
			fromAcc = "" + from.getAccountId();
		}
		
		
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", amount=" + amount + ", to=" + to.getAccountId()
		+ ", from=" + fromAcc + "]";
	}
}
