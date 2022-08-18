package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.exceptions.IncorrectCredentialsException;
import com.example.exceptions.UserAlreadyExistsException;
import com.example.models.Account;
import com.example.models.User;
import com.example.utils.LoggingUtil;

public class UserService {

	private UserDao userDao;
	
	
	public UserService(UserDao userDao){
	  		this.userDao = userDao;
	}
	
	public User registerUser(String first, String last, String email, String username, String password) {
		try {
			User u = new User(first, last, email, username, password);
			userDao.createUser(u);
			return userDao.readUserByUsername(username);
		} catch (Exception e) {
			LoggingUtil.getLogger().warn("There was an attempt to register with a username or email which was taken");
			throw new UserAlreadyExistsException();
		}
	}
	
	public User loginUser(String username, String password) {
		
		User u = userDao.readUserByUsername(username);
		
		if(u == null) {
			LoggingUtil.getLogger().warn("There was an attempt to login to a user which does not exist: " + username);
			throw new IncorrectCredentialsException();
		}
		
		if(!u.getPassword().equals(password)) {
			LoggingUtil.getLogger().warn("There was a failed login attempt for user: " + username);
			throw new IncorrectCredentialsException();
		}
		
		return u;
		
	}
	
	public User getUsersProfile(String username){

		return userDao.readUserByUsername(username);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
}
