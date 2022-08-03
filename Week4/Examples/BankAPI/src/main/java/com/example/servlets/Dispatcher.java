package com.example.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.CustomerController;
import com.example.controllers.RedirectController;

public class Dispatcher {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) {
		
		//Here, we would pass the requests and responses onto the correct controllers
		System.out.println("In the servlet dispatcher with URI: " + request.getRequestURI());
		
		//We will switch/determine which controller to call based on the uri
		switch(request.getRequestURI()) {
			case "/BankAPI/api/register":
				System.out.println("Call the controller to handle the register logic");
				CustomerController.register(request, response);
				break;
			case "/BankAPI/api/login":
				System.out.println("Call the controller to handle the login logic");
				CustomerController.login(request, response);
				break;
			case "/BankAPI/api/redirect":
				RedirectController.redirect(request, response);
				break;
			case "/BankAPI/api/ask":
				RedirectController.google(request, response);
				break;
			case "/BankAPI/api/auth/login":
				System.out.println("We would store the users info in a session");
		}
		
	}

}
