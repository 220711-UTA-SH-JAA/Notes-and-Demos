package com.example.controllers;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AccountDaoHibernate;
import com.example.dao.TransactionDaoHibernate;
import com.example.dao.UserDaoHibernate;
import com.example.models.Account;
import com.example.models.Transaction;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.TransactionService;
import com.example.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionController {
	
	private static AccountService accountService = new AccountService(new AccountDaoHibernate());
	private static UserService userService = new UserService(new UserDaoHibernate());
	private static TransactionService transactionService = new TransactionService(new TransactionDaoHibernate(), accountService, userService);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void doDeposit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("Must be logged in to deposit money");
			return;
		}
		
		LinkedHashMap<String, String> body = om.readValue(req.getInputStream(), LinkedHashMap.class);
		
		Integer accountNum = Integer.parseInt(body.get("accountNumber"));
		Double amount = Double.parseDouble(body.get("amount"));
		
		Account a = transactionService.deposit(accountNum, amount);
		
		res.getWriter().write(om.writeValueAsString(a));
		
	}
	
	public static void doWithdraw(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("Must be logged in to deposit money");
			return;
		}
		
		LinkedHashMap<String, String> body = om.readValue(req.getInputStream(), LinkedHashMap.class);
		
		Integer accountNum = Integer.parseInt(body.get("accountNumber"));
		Double amount = Double.parseDouble(body.get("amount"));
		
		Account a = transactionService.withdraw(accountNum, amount);
		
		res.getWriter().write(om.writeValueAsString(a));
	}
	
	public static void doTransfer(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("Must be logged in to deposit money");
			return;
		}
		
		LinkedHashMap<String, String> body = om.readValue(req.getInputStream(), LinkedHashMap.class);
		
		Integer toAccount = Integer.parseInt(body.get("to"));
		Integer fromAccount = Integer.parseInt(body.get("from"));
		Double amount = Double.parseDouble(body.get("amount"));
		
		Account a = transactionService.transfer(toAccount, fromAccount, amount);
		
		res.getWriter().write(om.writeValueAsString(a));
	}
	
	public static void viewTransactions(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("Must be logged in to deposit money");
			return;
		}
		
		User u = userService.getUsersProfile((String) req.getSession().getAttribute("user"));
		
		List<Transaction> transactions = transactionService.getUserTransactions(u);
		
		res.getWriter().write(om.writeValueAsString(transactions));
		
		return;
	}


}
