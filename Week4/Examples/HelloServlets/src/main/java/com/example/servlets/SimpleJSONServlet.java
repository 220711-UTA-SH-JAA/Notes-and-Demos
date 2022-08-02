package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * JSON (Javascript Object Notation)
 * Data exchange format used to send data over the web, and it is easy for humans AND machines to read
 * 
 * String format that represents objects in key/value pairs
 * 
 * JSON Object Syntax
 * {
 * 	"name": "Ethan",
 * 	"title": "trainer"
 * }
 * 
 * {} represent the entire object
 * Key: the fields of the object
 * Value: the value of the fields
 * - you can send arrays of data using this syntax
 * 	[{},{},{}]
 * 
 * Serialization Using Jackson
 * 
 * The Jackson API is used to convert java objects to Json object and vise versa
 * 
 * We will use Jackson to be able to send Java object back to the client in the form of JSON
 * 
 * We will also use Jackson to parse the bodies of our http requests into Java objects
 */

public class SimpleJSONServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	//Handle our get request to this servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//The first thing we want to do, is notify the client, that we are sending JSON data back
		response.setContentType("application/json");
		
		//Lets say, we want to query a specific user by their username
		//To do this, we can use a path query/query parameter in the url path
		//http://localhost:8080/HelloServlets/json?username=user
		
		User u = null;
		
		String username = request.getParameter("username");
		
		//You would probably call your service layer to do some logic based on the request
		System.out.println(username);
		if(username.equals("ethan")) {
			u = new User("Ethan", "password");
		}else {
			u = new User("User", "password");
		}
		
		System.out.println(u);
		
		//How do we write this to our client?
		//Using the ObjectMapper from Jackson
		
		System.out.println(mapper.writeValueAsString(u));
		
		response.getWriter().println(mapper.writeValueAsString(u));
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//Use the request to parse the request body
		//JSON is a String, so we can use take the data from the body, and create a new String in java
		//Then convert that string to an object
		String bodyData = new String(request.getInputStream().readAllBytes());
		
		//Now we can use the mapper to convert the stringified object into a java object
		//When you are using this mapper, YOU MUST MATCH THE EXACT CLASS FIELDS IN THE JSON OBJECT
		User u = mapper.readValue(bodyData, User.class);
		
		System.out.println(u);
		
		//Once we have our user, we could store on the db, or do some other logic
		response.setContentType("application/json");
		response.getWriter().write(mapper.writeValueAsString(u));
	}
	
	
	
	

}
