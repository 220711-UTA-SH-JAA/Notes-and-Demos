package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController {
	
	public static void invalidUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setStatus(404);
		
		res.getWriter().write("Invalid credentials, unable to login");
		
	}

	public static void invalidWithdraw(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setStatus(403);
		
		res.getWriter().write("Insufficient funds");
		
	}

}
