package com.example.models;

import java.util.Objects;

public class Student {
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Boolean attending;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String username, String email, String password,
			Boolean attending) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.attending = attending;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAttending() {
		return attending;
	}

	public void setAttending(Boolean attending) {
		this.attending = attending;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", email="
				+ email + ", password=" + password + ", attending=" + attending + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attending, email, firstName, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(attending, other.attending) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}
