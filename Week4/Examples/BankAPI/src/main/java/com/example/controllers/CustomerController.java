package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AccountDaoImpl;
import com.example.dao.CustomerDaoImpl;
import com.example.models.Customer;
import com.example.services.AccountService;
import com.example.services.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerController {
	
	//Static methods, that the dispatcher can call
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static CustomerService customerService = new CustomerService(new CustomerDaoImpl(), new AccountService(new AccountDaoImpl()));
	
	public static void register(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Running the register logic in the Customer Controller");
		
		try {
			String bodyData = new String(req.getInputStream().readAllBytes());
			
			Customer c = mapper.readValue(bodyData, Customer.class);
			
			c = customerService.registerCustomer(c.getFirstName(), c.getLastName(), c.getUsername(), c.getPassword());
			
			if(c == null) {
				//A generic client error, because my mind is going blank on the status codes
				res.setStatus(400);
				res.getWriter().write("Username already exists");
				return;
			}
			
			//201 means something was created
			res.setStatus(201);
			res.getWriter().write(mapper.writeValueAsString(c));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//This means there was some internal server error
			res.setStatus(500);
		}
		
	}
	
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Running the login logic in the Customer Controller");
		
		/* Forwarding requests with HttpServletRequest
		 * 
		 * Request dispatcher interface defines an object that passes along clients requests to other resources on the server
		 * 
		 * We are have two ways to foward our requests to somewhere else on the server
		 * 
		 * forward(req, res), passes a request from one servlet to another resource on the server, the contents of the request
		 * and the response are preserved and forwarded to the next resource which will process the and and return it to the
		 * client
		 * 
		 * include(req, res), forward the request and response, but does not entirely give up control over request and response object
		 * , instead this method includes the contentof the orginal resource in the response returned to the client
		 * 
		 * One last thing about forwarding, is the client will never know you forwarded their request
		 */
		
		try {
			
			String bodyData = new String(req.getInputStream().readAllBytes());
			
			System.out.println(bodyData);
			
			String username = mapper.readTree(bodyData).findValue("username").asText();
			
			//String username = req.getParameter("username");
			
			System.out.println(username);
			
			Customer loggedIn = customerService.loginCustomer(username);
			
			// I would like to forward our request/response to a Authentication controller, to save the users session so they don't have to
			// login again
			req.setAttribute("customer", loggedIn);
			
			//You could just set the session inside of the login method, but I wanted to show you all the forward method
			
			req.getRequestDispatcher("auth/login").forward(req, res);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			res.setStatus(500);
			e.printStackTrace();
		}
	}

}
