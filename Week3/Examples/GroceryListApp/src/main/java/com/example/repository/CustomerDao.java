package com.example.repository;

import java.util.List;

import com.example.models.Customer;

/*
 * This is a design pattern we will be following to separate our business logic from our database access code
 * - You want to create an interface which outlines the methods you want for your data access
 * - Implement that interface in a class for your specific needs/use cases
 * 		- Example: You may have a Dao implementation class or H2 Database, Writing to a File, and For Postgres
 * 		- You use those implementations to easily change where you are access the database
 * 
 */

public interface CustomerDao {
	
	/* If we remember back, the 4 main things we need are CREATE READ UPDATE DELETE */
	
	//Create
	void createCustomer(Customer c);
	
	//Read
	List<Customer> readAllCustomers();
	
	Customer readByUsername(String username);
	
	//Update
	void updateCustomer(Customer c);
	
	//Delete
	void deleteCustomer(int id);


}
