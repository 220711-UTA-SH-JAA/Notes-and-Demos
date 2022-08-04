package com.example.exceptions;

public class UserDoesNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException(){
		super("The user does not exist");
	}

}
