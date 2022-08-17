package com.example.models;

public class RegisterObject {
	
	public String firstName;
	public String lastName;
	public String email;
	public String username;
	public String password;
	
	public RegisterObject() {
		
	}
	
	public RegisterObject(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterObject [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
