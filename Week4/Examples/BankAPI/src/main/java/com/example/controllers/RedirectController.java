package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RedirectController {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void redirect(HttpServletRequest req, HttpServletResponse res) {
		/* Redirecting with HttpServletResponse
		 * The .sendRedirect(url) method on the HttpServletRes object will allow you to redirect the user to a resource on
		 * a different server
		 * 
		 * Literally sending the user elsewhere, you can send people to other sites, or to where you know there is some data
		 * 
		 */
		
		try {
			res.sendRedirect("https://www.tutorialspoint.com/servlets/index.htm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void google(HttpServletRequest req, HttpServletResponse res) {
		
		String bodyData;
		try {
			bodyData = new String(req.getInputStream().readAllBytes());
			String search = mapper.readTree(bodyData).findValue("search").asText();
			
			search = search.replace(' ', '+');
			
			res.sendRedirect("https://www.google.com/search?q="+search);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
