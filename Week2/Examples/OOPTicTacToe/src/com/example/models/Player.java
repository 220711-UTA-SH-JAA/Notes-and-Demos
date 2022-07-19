package com.example.models;

/*
 * We consider the java objects that only hold information models
 * Typically these will be the most encapsulated object in our software
 * 
 * Encapsulation
 * - Most straight forward pillar of OOP
 * - The idea of hiding the states and behavior of an object
 * 
 * The way we will hide the data and behaviors of an object is with access modifiers, and we can allow access to the
 * states using mutator methods
 * 
 * ACCESS MODIFIERS
 * 
 * public: makes the method or variable available throughout the entire application
 * protected: available within the same package and subclasses (children)
 * 	- If you remember packages group like classes/files, so maybe you want other classes in the package to have
 * 		access but not everywhere in the project
 * default (has no keyword): available within the same package
 * private: only available within the class
 * 	- This is how we can encapsulate the data in our models
 * 	- private keyword with public mutators
 * 
 * POJO vs Beans
 * 
 * POJO: a plain old java object
 * 
 * A Bean is a special POJO with the following properties
 * - They must be serializable aka, writable to a file
 * - All fields should be private
 * - Fields should have getters and setters
 * - There should be at least a no-args constructor
 * - Fields are only accessed by constructors and or getters and setters
 * 
 * We strive to create Beans, because they are perfectly encapsulated objects that can be written to files
 * 
 * 
 */

//public class Player means that this class is available throughout the entire project
//You can actually have multiple java classes in one file, the second class just must NOT be public
public class Player {
	
	//private String name means that we can only access this value from inside this class
	private String name;
	
	//We do not want the classes such as Driver to have direct access to score, but we do want to inherit the
	//member in an sub classes
	protected int score;
	
	public Player() {
		this.name = "";
		this.score = 0;
	}
	
	public Player(String name) {
		System.out.println("Calling the String argument constructor in Player");
		this.name = name;
		this.score = 0;
	}
	
	/*
	 * To access the name variable, we want to create public mutators, otherwise known as getters and setters
	 */
	//Setter methods are named setVarName and they set the value of whatever variable
	public void setName(String name) {
		this.name = name;
	}
	
	//Getter methods are named getVarName and they get the value of whatever variable
	public String getName() {
		return name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	
}
