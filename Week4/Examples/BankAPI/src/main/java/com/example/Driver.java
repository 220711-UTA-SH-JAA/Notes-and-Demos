package com.example;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoImpl;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.services.AccountService;
import com.example.services.CustomerService;

public class Driver {
	
	//The only reason this static, is because we are going to try to use it in the main method
	//private static CustomerDao customerDao = new CustomerDaoImpl();
	//private static CustomerService customerService = new CustomerService(customerDao);
	//private static AccountDao accountDao = new AccountDaoImpl();
	//private static AccountService accountService = new AccountService(accountDao);
	
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
		/*
		Customer loggedIn = customerService.loginCustomer("bob");
		
		if(loggedIn != null) {
			System.out.println("Welcome: " + loggedIn.getFirstName());
		}else {
			System.out.println("User does not exist");
		}
		*/
		//Lets manually test the account dao
		/*
		AccountDao accountDao = new AccountDaoImpl();
		//accountDao.createAccount(new Account(0, "Checking", 100.0, 1));
		System.out.println(accountDao.readAllAcounts());
		
		Account ethansChecking = new Account(1, "Checking", 100.0, 1);
		ethansChecking.setAccountBalance(1100.0);
		
		accountDao.updateAccount(ethansChecking);
		
		accountDao.deleteAccount(1);
		*/
		
		//Customer loggedIn = customerService.loginCustomer("emcgill");
		
		//Account ethansChecking = accountService.createAccount(loggedIn, "Checking", 100.0);
		//Account ethansChecking = new Account(2, "Checking", 1000.0, 1);
		//accountService.deposit(ethansChecking, 1000.00);
		//accountService.withdraw(ethansChecking, 100);
		//customerService.registerCustomer("Jeff", "Bezos", "jb", "amazonrules");
		//Customer jeff = customerService.loginCustomer("jb");
		//accountService.createAccount(jeff, "Savings", 100_000_000_000.0);
		//Account jeffsSavings = new Account(3, "Savings", 100_000_000_000.0, 10);
		
		//accountService.transfer(jeffsSavings, ethansChecking, 100_000.0);
	}

}
