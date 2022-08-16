package com.example.exceptions;

public class IncorrectCredentialsException extends RuntimeException {
	
	public IncorrectCredentialsException(){
		super("Incorrect credentials");
	}

}
