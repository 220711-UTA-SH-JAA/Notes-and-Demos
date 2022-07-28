package com.example.services;

import java.util.List;

import com.example.exceptions.CustomerDoesNotExistException;
import com.example.models.Customer;
import com.example.repository.CustomerDao;

public class CustomerService {
	
	//Notice that we are using the interface and not the concrete class
	//This is so we can detertime which DAO implementation to use whenever we create the Service object
	private CustomerDao customerDao;
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer addNewCustomer(String first, String last, String username, String email, String password) {
		
		Customer c = new Customer();
		//We are not setting the id, this will be set on the database
		//We could have created a special constructor with these specific parameters for this use case
		c.setFirstName(first);
		c.setLastName(last);
		c.setUsername(username);
		c.setEmail(email);
		c.setPassword(password);
		
		
		customerDao.createCustomer(c);
		
		return c;
		
	}
	
	public List<Customer> getAllCustomers(){
		return customerDao.readAllCustomers();
	}
	
	public Customer loginCustomer(String username) throws CustomerDoesNotExistException {
		Customer c = customerDao.readByUsername(username);
		
		if(c == null) {
			//This could also for example be InvalidCredentialsException in your project
			throw new CustomerDoesNotExistException();
		}
		
		return c;
	}
	
	public Customer updateCustomer(Customer cur, String first, String last, String username, String email, String password) {
		if(!first.equals("")) {
			cur.setFirstName(first);
		}
		
		if(!last.equals("")) {
			cur.setLastName(last);
		}
		
		if(!username.equals("")) {
			cur.setUsername(username);
		}
		
		if(!email.equals("")) {
			cur.setEmail(email);
		}
		
		if(!password.equals("")) {
			cur.setPassword(password);
		}
		
		customerDao.updateCustomer(cur);
		
		return cur;
	}
	
	public void removeCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

}
