package com.example.models;

/*
 * Inheritance in Java
 * 
 * A base class (or parent class) passes traits/behaviors down to a sub-class (or child class)
 * - This creates a parent-child relationship, or an is-a relationship
 * - All public and protected fields/methods will be inheritied by the child class
 * 
 * In java we implement inheritance using the extends keyword
 * 
 * Inheritance is useful for:
 * - It allows code to be more resuable
 * - It helps avoid boilerplate code (redudant), helping us abide by the programming guidline (Dont Repeat Yourself) DRY
 * 
 * Object Class
 * 
 * Is the root of all classes in Java
 * 
 * The object class provides a set of methods that all other objects/classes in java will inherit
 * - Object clone()
 * - boolean equals(Object o)
 * 		- by deafult this will act the same as ==, but many classes override this functionality for custom logic
 * - void finalize()
 * 		- run some logic right before garbage collection
 * - Class<?> getClass()
 * 		- Used to get the class, so we can get information about it
 * - int hashCode()
 * 		- returns an int indicating the hashcode
 * 		- If you override the .equals typically you are expected to also override the hashCode()
 * 		- The result of hashCode for object should not change over the lifetime of the application
 * 		- if .equals() returns true, the hashcode has to be the same
 * 		- if .equals() returns false, the hashcode doesn't have to be different
 * - void notify
 * - void notifyAll
 * - String toString()
 * 		- print a stringified version of the object, if not overriden, it will just print out the class path
 * - void wait()
 * - void wait(long timeout)
 * - void wait(long timeout, int nanos)
 * 
 */

public class TicTacToePlayer extends Player {
	
	//We can access all of the public methods from the Player class just like before
	//But we can also add in new members that are specific to this player
	private char symbol;
	
	/*
	 * Shadowing:
	 * - the practice in Java programming of having multiple variable with the same name within the same scope
	 * 		- If the parent class and child class have variable that are shared and have the same name
	 * 			the child class will override the value of the parent
	 * 
	 */
	
	//Since score is being inherited from the Player class, this will override any value orginally set by the Player class
	protected int score;
	
	public TicTacToePlayer(String name) {
		//We can use the super keyword to call a specific construtor on the parent class
		//This will call the constructor which takes in a single string in the parent class
		super(name);
		System.out.println("Calling the string arg constructor in TicTacToePlayer");
		score = 1;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getScore() {
		return this.score;
	}

}
