package com.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;

/*
 * Mappping classes to database tables with hibernate
 * There are two ways to map a class:
 * 	- Using annotations inside of the class
 * 	- Using XML mapping files
 * 
 * 	The more modern approach is to use annotations inside of the model classes, so that we will be doing\
 * 	- We just want less XML files in our java projects
 * 
 * Hibernate annotations come from JPA, so make sure we are importing these from javax.persistence
 *
 * To actually mark a class to be converted to a database table we need that @Entity annotation
 * - This class MUST have a public no-args constructor for hibernate to work
 * 
 * Another annotation we can place on the class level is @Table, this is used to give more information for the table
 * - used to name the table something different from the class name
 */

@Entity
@Table(name="users")
public class User {
	
	//Eventually we will store these in a db, but we may or may not get there today
	/*
	 * Every database table needs a primary key, the way we create a primary key with hibernate is @Id
	 * We can also use @GeneratedValue and give a attribute called strategey=GenerationType.IDENTITY
	 * One other optional annotation for properties is @Column, you can add different constraints to individual properties
	 * to mapping to the table
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String username;
	private String password;
	
	//One user has many accounts
	//mappedby should be the corresponding property of the other class
	@OneToMany(mappedBy="accountHolder", cascade = CascadeType.ALL)
	private Set<Account> accounts;
	
	//ManyToMany, we are going to say, that many users could have many transactions
	@ManyToMany(cascade= CascadeType.ALL)
	//We also need to setup the junction table
	@JoinTable(
			name="user_transaction_junction",
			joinColumns = {@JoinColumn(name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="transaction_id")}
	)
	private List<Transaction> transactions;
	
	public User() {
		this.accounts = new HashSet<>();
		this.transactions = new ArrayList<>();
	}
	
	public User(String first, String last, String email, String username, String password) {
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accounts = new HashSet<>();
		this.transactions = new ArrayList<>();
	}

	//All args once we have the other classes setup
	public User(Integer userId, String firstName, String lastName, String email, String username, String password,
			Set<Account> accounts, List<Transaction> transactions) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accounts = new HashSet<>();
		this.transactions = new ArrayList<>();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", accounts=" + accounts + ", transactions="
				+ transactions + "]";
	}

}
