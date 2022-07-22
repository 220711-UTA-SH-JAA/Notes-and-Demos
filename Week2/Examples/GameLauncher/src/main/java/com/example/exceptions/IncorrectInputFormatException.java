package com.example.exceptions;

/*
 * To create a custom exception, you simply have to extend the Exception class or the RuntimeException
 * - Then create constructor that you can from classes
 * 
 * 
 */
public class IncorrectInputFormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IncorrectInputFormatException() {
		//Is a super call to the Exception with the message you want with the exception
		super("The input provided was in the incorrect format");
	}
	
	public IncorrectInputFormatException(String message) {
		super(message);
	}

}
