package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.exceptions.IncorrectCredentialsException;
import com.example.exceptions.UserAlreadyExistsException;
import com.example.models.Account;
import com.example.models.User;

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
			e.printStackTrace();
			return null;
		}
	}
	
	public User loginUser(String username, String password) {
		if(username.equals("emcgill") && password.equals("password")) {
			return new User("Ethan", "McGill", "email@email.com", username, password);
		}
		throw new IncorrectCredentialsException();
	}
	
	public List<Account> getUsersAccounts(String username){
		//Call getUserByUsername().getAccounts();
		return new ArrayList<>();
	}
	
}
