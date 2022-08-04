package com.example.exceptions;

public class OverDraftException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverDraftException() {
		super("You may not withdraw more money than you own");
	}

}
