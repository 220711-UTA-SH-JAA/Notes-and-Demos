package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.IncorrectCredentialsException;
import com.example.models.Account;
import com.example.models.User;

public class UserService {

	//private UserDao userDao;
	
	/*
	 * 	public UserService(UserDao userDao){
	 * 		this.userDao = userDao;
	 *	}
	 */
	
	public UserService() {
		
	}
	
	public User registerUser(String first, String last, String email, String username, String password) {
		return new User(first, last, email, username, password);
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
