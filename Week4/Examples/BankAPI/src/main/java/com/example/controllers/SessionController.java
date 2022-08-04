package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SessionController {
	
	/*	Session Management
	 * 
	 * 	The HTTP protocol is stateless, meaning that it does not store any client information on the server
	 * 	
	 * 	But, we can create what we call sessions, and send that session information in every request that the client makes
	 * 
	 * 	We can use that session information to keep track of the user
	 * 	- When someone logs in, and we don't want to make them enter their information again
	 * 
	 * 	Session tracking is a mechanism a servlet can use to maintain the state about a series of requests, and there are 
	 *	several ways to do so
	 *	- HttpSession API
	 *	- URL Rewriting
	 *	- Hidden Form Fields
	 *	- Cookies
	 *
	 *	Http Sessions API
	 *
	 *	The servlet API provides the HttpSession API which provides a way to identify a user and their store their info in requests
	 *
	 *	The servlet can generate a unique id and give that to client, then the client will send that id with each request going foward
	 *	- Until we decide to invalidate that id
	 *
	 *	To create a session, you use the HttpServletRequest.getSession() method, if a session does not exist on the request,
	 *	it vreate a new one
	 *
	 *	Other useful methods of the HttpSession API
	 *	- setAttribute(key,object): bind some object to the session, ex. maybe you want to store the users name in the session
	 *	- getAttribute(key): this gets the attribute value IF it exists
	 *	- removeAttribute(key): remove that attribute from the session IF it exists
	 *	- invalidate(): destroy the session
	 *		- When its time to log the user out, we can destroy the session
	 *
	 *	URL Rewriting
	 *	is the process of providing a unique id that gets appended to the request URL, then the server will use that to identify the user
	 *	
	 *	URL rewriting is popular for maintaining a session when a browser does not support cookies
	 *
	 *	http://localhost:8080/api/home?id=2563456345
	 *
	 *	Hidden Form Fields
	 *	
	 *	Are form fields inserted directly into the html that the users cannot see
	 *
	 *	You can set some data in this field, the user will not see it directly, and when submit the forms the data will
	 *	come with it
	 *	- Anyone can inspect the page and still see the form field
	 *	- Not useful for important information
	 *	
	 * 	Cookies
	 * 	are key-value pairs that are stored in your browser, and sent to the server on an http request
	 * 	- The cookies value would be placed in a header in the request
	 * 
	 * 	The servlet can check for the presence of the cookie, and verify the user is logged in, or something else
	 * 
	 * 	We have two types of cookies:
	 * 	- Non-persistent: deleted when you close your browser
	 * 	- Persistent: will only be deleted when we request them to be
	 * 	
	 */
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void createSession(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Customer c = (Customer) req.getAttribute("customer");
		
		System.out.println(c);
		
		req.getSession();
		req.getSession().setAttribute("customer", c);
		
		res.getWriter().write(mapper.writeValueAsString(c));
	}
	
	public static void deleteSession(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		req.getSession().invalidate();
		
		res.getWriter().write("User logged out");
		
	}
	
	public static void checkSession(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		Customer c = (Customer) req.getSession().getAttribute("customer");
		
		if(c!= null) {
			res.getWriter().write("User logged in: " + c.getUsername());
			return;
		}
		
		res.getWriter().write("User not logged in");
		return;
	}

}
