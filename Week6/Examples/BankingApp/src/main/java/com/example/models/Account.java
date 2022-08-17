package com.example.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer accountId;
	
	@Column(name="account_type")
	private String type;
	
	/* Creating relationships between tables
	 * We map the relation ship with either @OneToMany @ManyToOne @OneToOne or @ManyToMany
	 * - If you have a OneToMany, you must have a corresponing ManyToOne on the other class making the relationship
	 */
	//Many accounts to one User
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//Join column will take some info from the other object (such as the id) and create a column for that in this table
	@JoinColumn(name="account_holder")
	//What JSONIgnore will do, is ignore this property when we make HTTP responses
	@JsonIgnore
	private User accountHolder;
	
	@Column(name="account_balance")
	private Double balance;
	
	@OneToMany(mappedBy="to", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> toTransactions;
	
	@OneToMany(mappedBy="from", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> fromTransactions;
	
	public Account() {
		super();
		this.toTransactions = new ArrayList<>();
		this.fromTransactions = new ArrayList<>();
	}
	
	public Account(String type, User accountHolder) {
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
		this.toTransactions = new ArrayList<>();
		this.fromTransactions = new ArrayList<>();
	}

	public Account(Integer accountId, String type, User accountHolder, Double balance, List<Transaction> toTransactions, List<Transaction> fromTransactions) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.toTransactions = toTransactions;
		this.fromTransactions = fromTransactions;
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

	public List<Transaction> getToTransactions() {
		return toTransactions;
	}

	public void setToTransactions(List<Transaction> toTransactions) {
		this.toTransactions = toTransactions;
	}

	public List<Transaction> getFromTransactions() {
		return fromTransactions;
	}

	public void setFromTransactions(List<Transaction> fromTransactions) {
		this.fromTransactions = fromTransactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", accountHolder=" + accountHolder + ", balance="
				+ balance + ", toTransactions=" + toTransactions + ", fromTransactions=" + fromTransactions + "]";
	}

	
}
