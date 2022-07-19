package com.example.models;

/*
 * Abstraction in Java
 * - This is a principle where we centralize common characteristics and generalize behaviors into conceptual classes
 * 
 * We are going to hide the underlying complexities through a simplified interface
 * - Hiding how something works, but still allowing users to know what the functions are
 * 
 * In Java we will do this with Abstract Classes and Interfaces
 * 
 * Java has special interfaces called Marker Interfaces, these work similarly to annotations, and provide metadata to
 * the compiler, the most common one is Serializable, which tells the compiler an object can be written to a file
 * 
 */

//To make an abstract class, we just use the keyword abstract
//We cannot make a new instance of Game, we must inherit the functionality and instantiate a subclass than inherits game
//Abstract classes can have both abstract methods and non-abstract methods
public abstract class Game {

	/* NONACCESS MODIFIERS
	 * 
	 * Are java keywords that modify the functionality of java, but no the access levels
	 * - There are technically 7 non-access modifiers, but I will only 4 of them, because the other 3 are used
	 * 		rarely
	 * 
	 *  static denote a class member as static/class scope
	 *  - if a variable or method is denoted as static, that means it belong to the class
	 *  - static methods:
	 *  	- can only access other static members
	 *  	- primarily useful because you don't need an instance of the class to call the method
	 *  	- Game.staticMethod()
	 *  - static variables:
	 *  	- will be same across all instances of the class
	 *  	- save memory because the same value is shared across all the instances
	 *  	- don't need an instance of the class to access the variable
	 *  	- Game.variable
	 *  
	 *  final makes whatever it is applied to unchangable/you cannot reassign the value
	 *  - when applied to a variable
	 *  	- You cannot reassign the variable
	 *  	- final variable are cached by the JVM, so you could possibly increase your performance
	 *  	- final variable are also safe to share between multi-threaded environments
	 *  - when applied to a class, the class can not longer be extened
	 *  - when applied to a method, you can no longer override the method
	 *  
	 *  abstract keyword can mean one of two things
	 *  - when applied to a class, the class can no longer be instantiated directly, you must inherit it
	 *  - when applied to a method, the method cannot have a body (logic), and it must be given its implementation by
	 *  	a child class
	 *  
	 *  transient keyword marks a class variable as not serializable
	 *  - You are not allowed to write the variable to a file
	 */
	
	//final variables are typically denoted by all uppercase, so its easy to tell
	public static final String NAME = "General Game";
	
	private Board board;
	
	private Player[] players;
	
	//The abstract keyword on a method, means we must implement this method on the class that we are inheriting to
	abstract void calculateWinner();
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
}
