package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//To create an HTTPServlet we must extend HttpServlet Class
public class TextServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/*	Servlet Life Cycle
	 * 	
	 * There are three main methods of the servlet life cycle
	 * - init()
	 * - service()
	 * - destroy()
	 * 
	 * The steps of the servlet life cycle
	 * 
	 * 1. Loading of the servlet
	 * 	- When the application server loads up, the server container deploys and loads all of the servlet classes
	 * 2. Create an instance of a servlet
	 * 	- Once the servlet classes are loaded, the servlet container creates a single instance of each class
	 * 3. Invoke init() once for each servlet
	 * 4. Invoke the service() each time the servlet is called
	 * 5. Once the server is shutting down, the destroy() is called just once for each servlet
	 */
	
	//To handle http requests with custom logic, we must override one of the HttpServlet handler methods
	//This is the syntax for any and all do... methods of the HttpServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		/* HttpServletRequest and HttpServletResponse objects
		 * 	- are objects that contain information about the http request or http response
		 * 
		 * HttpServletRequest:
		 * - Provide the information about the request coming from the client
		 * 		- Use this to get the URL provided, and headers, and the body if one is provided
		 * 		- This is also heavily used for session management later on
		 * HttpServletResponse:
		 * 	- Allow us to customize the response sent back to the client
		 * 	- We can set the data types we are sending back, we change the status code, and headers
		 * 	- Write back with the built in printWriter object, and send Java objects using third party libraries
		 */
		
		//Lets get some information from the request
		String requestURI = request.getRequestURI();
		
		
		//This will not work, because the config was setup on a different servlet
		String attemptConfig = getServletConfig().getInitParameter("my-config");
		
		System.out.println("Config: " + attemptConfig);
		
		String contextString = getServletContext().getInitParameter("global-context");
		
		System.out.println("Context: " + contextString);
		
		System.out.println("Request recieved from: " + requestURI);
		
		//This is how we will set the content to send back to the client
		PrintWriter print = response.getWriter();
		
		print.println("The embarrassing picture of Spongebob at the Christmas Party");
		
	}

}
