package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.AccountController;
import com.example.controllers.CustomerController;
import com.example.controllers.ErrorController;
import com.example.controllers.RedirectController;
import com.example.controllers.SessionController;

public class Dispatcher {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
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
				SessionController.createSession(request, response);
				break;
			case "/BankAPI/api/auth/logout":
				SessionController.deleteSession(request, response);
				break;
			case "/BankAPI/api/auth/check":
				SessionController.checkSession(request, response);
				break;
			case "/BankAPI/api/invalid/user":
				System.out.println("User didn't exist");
				ErrorController.invalidUser(request, response);
				break;
			case "/BankAPI/api/account/create":
				AccountController.createAccount(request, response);
				break;
			case "/BankAPI/api/account/deposit":
				AccountController.depositMoney(request, response);
				break;
			case "/BankAPI/api/account/withdraw":
				AccountController.withdraw(request, response);
				break;
			case "/BankAPI/api/invalid/withdraw":
				ErrorController.invalidWithdraw(request, response);
				break;
			case "/BankAPI/api/account/transfer":
				AccountController.transfer(request, response);
				break;
		}
		
	}

}
