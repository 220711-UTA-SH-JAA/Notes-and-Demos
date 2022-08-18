package com.example.exceptions;

public class InvalidTransactionException extends RuntimeException {
	
	public InvalidTransactionException() {
		super("Unable to perform transaction, please try again with a different amount");
	}

}
