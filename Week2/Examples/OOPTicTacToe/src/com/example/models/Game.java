package com.example.models;

public class Game {

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
	public static final String NAME = "Tic Tac Toe";
	
	
	public static char[][] board = new char[3][3];
	
	public static void play() {
		System.out.println("Lets play the game");
	}
	
}
