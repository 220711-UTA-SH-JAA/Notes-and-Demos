package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.AccountController;
import com.example.controllers.ExceptionsController;
import com.example.controllers.TransactionController;
import com.example.controllers.UserController;

public class Dispatcher {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("We made it to the dispatcher");
		
		switch(req.getRequestURI()) {
			case "/BankingApp/api/login":
				UserController.doLogin(req, res);
				break;
			case "/BankingApp/api/register":
				UserController.doRegister(req, res);
				break;
			case "/BankingApp/api/profile":
				UserController.getProfile(req, res);
				break;
			case "/BankingApp/api/account":
				AccountController.doRegisterAccount(req, res);
				break;
			case "/BankingApp/api/accounts":
				AccountController.doGetAccounts(req, res);
				break;
			case "/BankingApp/api/deposit":
				TransactionController.doDeposit(req, res);
				break;
			case "/BankingApp/api/withdraw":
				TransactionController.doWithdraw(req, res);
				break;
			case "/BankingApp/api/transfer":
				TransactionController.doTransfer(req, res);
				break;
			case "/BankingApp/api/transactions":
				TransactionController.viewTransactions(req, res);
				break;
			case "/BankingApp/api/exceptions/users/exists":
				ExceptionsController.unableToRegister(req, res);
				break;
			case "/BankingApp/api/exceptions/users/incorrect":
				ExceptionsController.incorrectCredentials(req, res);
				break;
			case "/BankingApp/api/exceptions/transaction/invalid":
				ExceptionsController.invalidTransaction(req, res);
				break;
		}
		
	}

}
