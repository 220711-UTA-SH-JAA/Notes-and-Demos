package com.example.exceptions;

public class ListDoesNotExistException extends RuntimeException{
	
	public ListDoesNotExistException() {
		super("This list specified does not exist");
	}
	
}
