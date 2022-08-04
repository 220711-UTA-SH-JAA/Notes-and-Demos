package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AccountDaoImpl;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountController {
	
	private static AccountService accountService = new AccountService(new AccountDaoImpl());
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void createAccount(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		if(customer == null) {
			res.setStatus(403);
			res.getWriter().write("You must be logged in to create an account");
			return;
		}
		
		String bodyData = new String(req.getInputStream().readAllBytes());
		
		Account a = mapper.readValue(bodyData, Account.class);
		
		accountService.createAccount(customer, a.getAccountType(), a.getAccountBalance());
		
		customer.setAccounts(accountService.getCustomerAccounts(customer));
		
		req.getSession().setAttribute("customer", customer);
		
		res.getWriter().write(mapper.writeValueAsString(customer));
		
	}
	
	public static void depositMoney(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		if(customer == null) {
			res.setStatus(403);
			res.getWriter().write("You must be logged in to create an account");
			return;
		}
		
		String bodyData = new String(req.getInputStream().readAllBytes());
		
		Integer accountNumber = Integer.parseInt(mapper.readTree(bodyData).findValue("accountNumber").asText());
		Double amount = Double.parseDouble(mapper.readTree(bodyData).findValue("amount").asText());
		
		System.out.println("AccountNumber: " + accountNumber + " amount: " + amount);
		
		
		for(Account a : customer.getAccounts()) {
			if(a.getAccountId() == accountNumber) {
				accountService.deposit(a, amount);
				res.getWriter().write("Amount: " + amount + " was deposited");
				return;
			}
		}
		
		res.setStatus(401);
		res.getWriter().write("You are unauthorized to deposit money in acounts that are not yours");
		return;
	}
	
	public static void withdraw(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		if(customer == null) {
			res.setStatus(403);
			res.getWriter().write("You must be logged in to create an account");
			return;
		}
		
		String bodyData = new String(req.getInputStream().readAllBytes());
		
		Integer accountNumber = Integer.parseInt(mapper.readTree(bodyData).findValue("accountNumber").asText());
		Double amount = Double.parseDouble(mapper.readTree(bodyData).findValue("amount").asText());
		
		System.out.println("AccountNumber: " + accountNumber + " amount: " + amount);
		
		for(Account a : customer.getAccounts()) {
			if(a.getAccountId() == accountNumber) {
				accountService.withdraw(a, amount);
				res.getWriter().write("Amount: " + amount + " was withdrawn");
				return;
			}
		}
		
		res.setStatus(401);
		res.getWriter().write("You are unauthorized to withdraw money from accounts that are not yours");
		return;
	}
	
	public static void transfer(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		if(customer == null) {
			res.setStatus(403);
			res.getWriter().write("You must be logged in to create an account");
			return;
		}
		
		String bodyData = new String(req.getInputStream().readAllBytes());
		
		Integer fromAccount = Integer.parseInt(mapper.readTree(bodyData).findValue("fromAccount").asText());
		Integer toAccount = Integer.parseInt(mapper.readTree(bodyData).findValue("toAccount").asText());
		Double amount = Double.parseDouble(mapper.readTree(bodyData).findValue("amount").asText());
		
		Account from = null;
		
		for(Account a : customer.getAccounts()) {
			if(a.getAccountId() == fromAccount) {
				from = a;
			}
		}
		
		Account to = accountService.getAccountByNumber(toAccount);
		
		//if from == null you dont own the account, if to == null the other account doesn't exist
		if(from == null || to == null) {
			res.setStatus(403);
			res.getWriter().write("Unable to make the requested transfer");
			return;
		}
		
		accountService.transfer(from, to, amount);
		
		res.getWriter().write("Money successfully transferred");
		
	}
	
	

}
