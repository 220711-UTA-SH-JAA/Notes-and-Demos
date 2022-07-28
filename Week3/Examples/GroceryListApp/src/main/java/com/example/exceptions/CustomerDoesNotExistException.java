package com.example.exceptions;

public class CustomerDoesNotExistException extends Exception {
	
	public CustomerDoesNotExistException() {
		super("The customer attempting to login does not exist");
	}

}
