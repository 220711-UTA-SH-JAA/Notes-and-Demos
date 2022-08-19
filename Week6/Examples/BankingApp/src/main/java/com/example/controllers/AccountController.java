package com.example.controllers;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AccountDaoHibernate;
import com.example.dao.UserDaoHibernate;
import com.example.models.Account;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountController {
	
	private static ObjectMapper om = new ObjectMapper();
	private static AccountService accountService = new AccountService(new AccountDaoHibernate());
	private static UserService userService = new UserService(new UserDaoHibernate());
	
	public static void doRegisterAccount(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("You must be a logged in member to open an account");
			return;
		}
		
		LinkedHashMap<String, String> body = om.readValue(req.getInputStream(), LinkedHashMap.class);
		
		String type = body.get("type");
		User u = userService.getUsersProfile((String) req.getSession().getAttribute("user"));
		
		Account a = accountService.registerAccount(type, u);
		
		res.setStatus(201);
		res.getWriter().write(om.writeValueAsString(a));
		return;
	}
	
	public static void doGetAccounts(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("You must be a logged in member to open an account");
			return;
		}
		
		User u = userService.getUsersProfile((String) req.getSession().getAttribute("user"));
		
		List<Account> accounts = accountService.getAccountsByUser(u);
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(accounts));
		return;
		
	}

}
