package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigContextExample extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		String configString = getServletConfig().getInitParameter("my-config");
		
		System.out.println("Config: " + configString);
		
		String contextString = getServletContext().getInitParameter("global-context");
		
		System.out.println("Context: " + contextString);
		
	}

}
