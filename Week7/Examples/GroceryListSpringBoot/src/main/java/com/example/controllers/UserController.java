package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.User;
import com.example.services.UserService;
import com.example.validation.UserValidation;

//Mark the class with @RestController to tell spring to manage this, and automatically return the values to the client
@RestController()
//Map our UserController requests to http://localhost:PORT/users
@RequestMapping("/users")
public class UserController {
	
	//We need to autowire our Service
	private UserService userService;
	
	//To use the validator, we must have an object binder inside of our controller, so lets set that up
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidation());
	}
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//If we want to use Validator in our register we need to modify the method slightly
	//Lets make our register endpoint
	//http://localhost:PORT/users/register
	@PostMapping("/register")
	public User registerUser(@RequestBody @Validated User u, BindingResult result) {
		
		System.out.println(u);
		
		if(result.hasErrors()) {
			System.out.println("There was an error validating");
			System.out.println(result.getAllErrors());
			return null;
		}
		
		return userService.registerUser(u);
	}
	
	//Lets make our login endpoint
	//http://localhost:PORT/users/login
	@PostMapping("/login")
	public User loginUser(@RequestBody LinkedHashMap<String, String> body) {
		return userService.loginUser(body.get("username"), body.get("password"));
	}
	
	//If the user signs in with incorrect credentials, it will result in an exception, lets handle that exception
	@ExceptionHandler({InvalidCredentialsException.class})
	public ResponseEntity<String> handleIncorrectCredentials(){
		return new ResponseEntity<String>("The username or password you input was incorrect", HttpStatus.FORBIDDEN);
	}

}
