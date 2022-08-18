package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.utils.LoggingUtil;

public class ExceptionsController {

	public static void unableToRegister(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.setStatus(409);
			res.getWriter().write("Unable to register user, please try again with a different username or email");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
		
	}

	public static void incorrectCredentials(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.setStatus(409);
			res.getWriter().write("Invalid Credentials, please try again");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
		
	}
	
	public static void invalidTransaction(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setStatus(403);
			res.getWriter().write("Invalid transactions, please be sure you enter a positive amount, or you have enough funds");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	

}
