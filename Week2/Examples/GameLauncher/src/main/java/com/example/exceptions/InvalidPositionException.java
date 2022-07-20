package com.example.exceptions;

public class InvalidPositionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPositionException() {
		super("The position you specified is invalid");
	}
	
	public InvalidPositionException(String message) {
		super(message);
	}
	
}
