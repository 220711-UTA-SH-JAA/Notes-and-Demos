package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.CustomerDao;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.Customer;

public class CustomerService {

	//This needs access to the DAO to be able to query the database
	//We will pass an instance of the Customer DAO to the service through the constructor
	private CustomerDao customerDao;
	private AccountService accountService;
	
	
	//Now when we create an instance of our CustomerService, we MUST pass it an instance of the CustomerDao
	public CustomerService(CustomerDao customerDao, AccountService accountService) {
		this.customerDao = customerDao;
		this.accountService = accountService;
	}
	
	public Customer registerCustomer(String first, String last, String username, String password) {
		
		try {
			Customer c = new Customer(0, first, last, username, password);
			//customerDao.createCustomer(c) will throw an SQLException if the username already exists in the table
			//We won't create the user, and we will return null, which we can check for later
			customerDao.createCustomer(c);
			return c;
		} catch(SQLException e) {
			return null;
		}
		
	}
	
	public Customer loginCustomer(String username) {
		
		List<Customer> customers = customerDao.getAllCustomers();
		
		for(Customer c: customers) {
			if(c.getUsername().equals(username)) {
				c.setAccounts(accountService.getCustomerAccounts(c));
				return c;
			}
		}
		
		//You may want to instead throw an exception
		throw new UserDoesNotExistException();
		
	}
	
	// We could continue with more CRUD operations, but this is really all we need for now
	
}
