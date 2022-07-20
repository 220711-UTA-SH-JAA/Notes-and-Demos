package com.example.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExample {

	/*
	 * Exceptions are events that occur during the execution of our code, and they disrupt the normal flow of the app
	 * 
	 * When an exception occurs, java create an Exception object and it gets "thrown"
	 * 
	 * Exceptions are a way for Java to tell us developers that something has gone wrong, but we can recover
	 * if handled properly
	 * 
	 * Class Hierarchy (Drawing of it in the hand written notes on github)
	 * 
	 * The top level of the hierarchy is the Throwable class
	 * - Any class which extends throwable can be "thrown" with the throw keyword
	 * 
	 * The two main classes that extend Throwable are Exception and Error
	 * - Error is similar to Exception, except it indicates something worse has happened and the program has stopped
	 * 		working
	 * 
	 * Any class (outside of RuntimeException) that extends Exception is a Checked Exception
	 * - Caught at compile
	 * 		- We MUST catch/handle at compile
	 * 
	 * Any class that extends RuntimeException is a Unchecked Exception
	 * - Caught at runtime
	 * 		- We are NOT required to catch/handle
	 * 		- There will occur because of a bug in the code, rather than for example a missing file
	 */
	
	public static void main(String args[]) {
		
		//Handling and declaring exceptions
		
		//1. Using a try catch block
		//2. By using the throws keyword on the method itself
		
		//The otherway we can handle exceptions is with a try/catch block
		//Try to run some code, if an exception occurs, run the catch logic
		try {
			//Some code that may throw an exception
			throwExceptionMethod(3);
			//We can attempt to catch multiple exceptions in a single catch block with the pipe symbols ||
			//We can also have multiple catch blocks for different exceptions
			//The only catch is that it must go from most specific to least specific
		} catch (FileNotFoundException e) {
			//If an exception is caught, we can deal with it here
			//You don't have to print to the console, maybe you only do this during development for debug
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}//The finally block will always run the code inside of it no matter if there was an exception caught or not
		finally {
			//Used for clean up if you shut down after the exception
			//Used for fixing the exception etc
			System.out.println("Something went wrong, but I will run anyway");
		}
		
		//Runtime exceptions do not need to be surrounded by try catch, because as a programmer we don't actually
		//know when may occur
		throw new RuntimeException();
		
		
	}
	
	//Exception creates a checked exception, so we MUST handle any Exception that occurs
	//One way to handle an exception is by "ducking" and that uses the throws keyword
	//ducking the reponsibility, and passing to the next method
	//When we say throws Exception, we are saying that the throwExceptionMethod is not responsible for handling
	//Any exception occurs inside of it, rather WHOEVER call this method is responsible for this
	private static void throwExceptionMethod(int num) throws Exception{
		
		switch(num) {
			case 1:
				//To create and cause an exception, we use the the constructor of the exception, and use the throw
				//keyword to throw it
				//The throw keyword will only work on objects that are Throwable
				throw new FileNotFoundException();
			case 2:
				throw new IOException();
			default:
				throw new Exception();
		}
		
		
	}
	
}
