package com.example.exceptions;

public class ExpectedNumbersException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExpectedNumbersException() {
		super("The input expected were numbers, but got some other type of character");
	}
	
	public ExpectedNumbersException(String message) {
		super(message);
	}
	

}
