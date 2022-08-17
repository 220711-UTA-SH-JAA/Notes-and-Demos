package com.example.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	
	public UserAlreadyExistsException() {
		super("The username or email specified is already in use");
	}

}
