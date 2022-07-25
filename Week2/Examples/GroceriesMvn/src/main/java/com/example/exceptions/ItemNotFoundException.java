package com.example.exceptions;

public class ItemNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException() {
		super("The item you specified was not found");
	}

}
