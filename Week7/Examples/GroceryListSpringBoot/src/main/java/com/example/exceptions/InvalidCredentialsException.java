package com.example.exceptions;

public class InvalidCredentialsException extends RuntimeException {

	public InvalidCredentialsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidCredentialsException() {
		super("Invalid Credentials");
		// TODO Auto-generated constructor stub
	}
	

}
