package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.example.dao.UserDaoHibernate;
import com.example.models.LoginObject;
import com.example.models.RegisterObject;
import com.example.models.User;
import com.example.services.UserService;
import com.example.utils.HibernateUtil;
import com.example.utils.LoggingUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {
	
	private static UserService userService = new UserService(new UserDaoHibernate());
	private static ObjectMapper om = new ObjectMapper();
	
	public static void doLogin(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		
		LoginObject lo = om.readValue(req.getInputStream(), LoginObject.class);
		
		System.out.println(lo);
		
		User loggedIn = userService.loginUser(lo.username, lo.password);
		
		LoggingUtil.getLogger().info("User: " + loggedIn.getUsername() + " was logged in");
		
		req.getSession();
		
		req.getSession().setAttribute("user", loggedIn.getUsername());
		
		res.getWriter().write(om.writeValueAsString(loggedIn));
		
		return;
	}
	
	public static void doRegister(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		
		
		RegisterObject ro = om.readValue(req.getInputStream(), RegisterObject.class);
		
		System.out.println(ro);
		
		User registered = userService.registerUser(ro.firstName, ro.lastName, ro.email, ro.username, ro.password);
		
		LoggingUtil.getLogger().info("A new user was registered: " + ro.username);
		
		res.setStatus(201);
		res.getWriter().write(om.writeValueAsString(registered));
		
	}
	
	public static void getProfile(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//If the user is not logged in, they cannot get their profile
		if(req.getSession().getAttribute("user") == null) {
			res.setStatus(403);
			res.getWriter().write("Users must be logged in to see their profile information");
			return;
		}
		
		String username = (String) req.getSession().getAttribute("user");
		
		User loggedIn = userService.getUsersProfile(username);
		
		res.getWriter().write(om.writeValueAsString(loggedIn));
		
	}

}
