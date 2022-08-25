package com.example.exceptions;

public class ItemDoesNotExistException extends RuntimeException{
	
	public ItemDoesNotExistException() {
		super("Item does not exist");
	}

}
