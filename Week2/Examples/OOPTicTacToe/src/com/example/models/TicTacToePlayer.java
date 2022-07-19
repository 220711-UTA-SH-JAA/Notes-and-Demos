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

/*
 * Annotations
 * - Are special construct in Java that use the @symbol, and the they provide the compiler with some data about the
 * class, method, or variable
 * 
 * Annotations can be used on classes, methods, and variables
 * 
 * Annotations are often used by other libraries to mark/declare something has been abstracted away
 * - The reflections API may look through all the classes in your program to see if they have certain annotations
 * 		and if there are, the library you are using may do some logic
 * 
 * Some examples:
 * - @Override
 * - @Test
 * 
 */

/* Polymorphism goes hand and hand with inheritance
 * - The ability for an object to take on many forms
 * 
 * The ways we achieve polymorphism in Java is by:
 * - Method overloading
 * - Method overriding
 * - Covariant return types
 * - Casting
 * 
 * Covariant Return types has to do with method returns/overriding methods
 * - We can change the return type of an overrided method, as long as the changed method returns a child of the orginal object
 * public Object returnMe() -> public String returnMe()
 * - You can change the acccess modifier of an overrided method as long as its not MORE restrictive
 * protected Object returnMe() -> public Object returnMe()
 * - change the exception thrown, as long as its a sub class of the original
 * public Object returnMe() throws Exception -> public Object returnMe() throws SomeSpecificExceptionThatExtendsException
 * 
 * Casting
 * - Upcasting: allows you to assign a child object to a parent object, this works because the child will have all the
 *		properties and methods of the parent object, however, it may be missing some of the child functionalities
 *
 *	- Downcasting: is the opposite of upcasting, it allows you to assign a parent object to child object, however, you
 *		cannot garentee that the parent object will have all the properties of the child object, leading to problems
 */

//TicTacToePlayer extends Player, is saying that TicTacToePlayer is also a Player by inheriting the info from Player
public class TicTacToePlayer extends  Player{
	
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
	
	
	/* Method Overloading
	 * 
	 * When two or more methods on a class have the same name, but have have different signatures by
	 * changing the parameter list
	 * - Change the number of parameters, the order of parameters, the types of the parameters
	 * - The return type of the method MUST stay the same
	 * - Which version of the method that runs, is determined at compile time, making this compile time polymorphism
	 * 
	 */
	
	//Technically speaking, constructors are special methods, and have the same name, so when we create multiple
	//constructors, we are overloading methods, and achieving polymorphism
	public TicTacToePlayer() {
		
	}
	
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
	
	/* Method Overriding
	 * 
	 * A method in a child class has the same name and signature as a method in the parent class, but it has a different
	 * implementation
	 * - Makes class hierarchies more flexible and dynamic
	 * - Is a form of run-time polymorphism
	 * 
	 * If a subclass implements the same static methods as its parent, the method is hidden. Method hiding replaces the
	 * parent method in the calls defined by the child class
	 * 
	 * It is not necessary, but we can try to help the compiler out by marking out methods with @Override
	 */
	
	@Override
	public int getScore() {
		return this.score;
	}
	
	//toString comes from the object class we talked about earlier, we can override the default implementation to
	//print out our own string version of our object
	//With reference types, java will automatically call toString if you pass it into a syso
	@Override
	public String toString() {
		return "Player: {name:" + this.getName() + " score: " + this.score + " symbol: " + this.symbol + "}";
	}

}
