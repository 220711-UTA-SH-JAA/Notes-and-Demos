package com.example;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.models.Customer;
import com.example.services.CustomerService;

public class Driver {
	
	//The only reason this static, is because we are going to try to use it in the main method
	private static CustomerDao customerDao = new CustomerDaoImpl();
	private static CustomerService customerService = new CustomerService(customerDao);
	
	public static void main(String args[]) {
		//We know our dao methods work, now lets move onto the services
		//We will simply test our daos/services before making this an api
		//We pass a new customer to our dao method to create a user, to test if it works
		//This one is good, onto the next
		//customerDao.createCustomer(new Customer(0, "Patrick", "Nelson", "pnelson", "password"));
		//List<Customer> customers = customerDao.getAllCustomers();
		//System.out.println(customers);
		
		//Customer ethan = new Customer(1, "Ethan", "McGill", "emcgill", "p4ssw0rd");
		
		/*
		try {
			customerDao.updateCustomer(ethan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not update the user");
		}
		*/
		//customerDao.deleteCustomer(3);
		//Start testing our services
		/*Customer c = customerService.registerCustomer("Patrick", "Nelson", "pnelson2", "password");
		if(c != null) {
			System.out.println("Customer: " + c + " was created");
		}else {
			System.out.println("Username already exists, choose a different one");
		}
		*/
		Customer loggedIn = customerService.loginCustomer("bob");
		
		if(loggedIn != null) {
			System.out.println("Welcome: " + loggedIn.getFirstName());
		}else {
			System.out.println("User does not exist");
		}
	}

}
