package com.example.models;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	//Eventually we will store these in a db, but we may or may not get there today
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Set<Account> accounts;
	
	public User() {
		
	}
	
	public User(String first, String last, String email, String username, String password) {
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accounts = new HashSet<>();
	}

	//All args once we have the other classes setup
	public User(Integer userId, String firstName, String lastName, String email, String username, String password,
			Set<Account> accounts) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}
}
