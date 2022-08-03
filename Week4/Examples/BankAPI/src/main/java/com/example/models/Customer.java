package com.example.models;

public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Customer() {
		//This will create a Customer object with default values
	}
	
	public Customer(int id, String first, String last, String username, String password) {
		this.customerId = id;
		this.firstName = first;
		this.lastName = last;
		this.username = username;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + "]";
	}
}
