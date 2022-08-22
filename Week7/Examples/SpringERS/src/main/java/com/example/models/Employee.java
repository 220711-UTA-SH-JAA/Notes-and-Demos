package com.example.models;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Boolean manager;
	private Set<Ticket> tickets;
	
	//With Spring we will always want a no-arg and all arg and proper getters and setters
	public Employee() {
		super();
		tickets = new HashSet<>();
	}

	public Employee(Integer employeeId, String firstName, String lastName, String username, String password,
			Boolean manager, Set<Ticket> tickets) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.manager = manager;
		this.tickets = tickets;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", manager=" + manager + ", tickets=" + tickets
				+ "]";
	}
}
