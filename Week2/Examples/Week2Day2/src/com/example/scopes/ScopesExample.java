package com.example.scopes;

public class ScopesExample {
	
	/*
	 * In have 4 different scopes for varaibles
	 * 	- Each scope determines how long a variable is alive/available, and where the variable is available from
	 * 
	 * Instance Scope
	 * - Belongs to the object
	 * - Each individual object derived from a class could have a different value for this variable
	 * - While the object exists in memory, instance scope variables are available to the program
	 * 
	 * Static Scope
	 * - Belongs to the class itself
	 * - If change the value in one object instance of the class, it will change across all object instances of the class
	 * - While this scope is sort of special, it exists for the same amount of time as the instance scope
	 * 
	 * Method Scope
	 * - Variables created inside of methods
	 * - Once the method is done running, the variable is not longer available
	 * - Once the method is popped off the stack, all the local variables to it are also popped off the stack
	 * 
	 * Block Scope
	 * - More specific, individual blocks of code
	 * - Typically loops, or branching
	 * - You can't access outside of the block, once outside of the block of code, the values are no longer accessible
	 * 
	 */
	
	//Instance scope, because every instance of this class, could store a different value for age
	int age;
	
	//Static scope, becasue it has the static keyword, every instance of this class will share this same value
	static String species = "human";
	
	void humanToDogYears(int age) {
		//This would be a method scope variable because it was created inside of a meothod
		int multiplier = 7;
		if(age < 2) {
			
			//This is a block scope variable, we cannot access it outside of the if statement
			int youngAgeMultiplier = 4;
			System.out.println(age*youngAgeMultiplier);
			return;
		}
		
		//multiplier = youngAgeMultiplier;
		System.out.println(age * multiplier);
	}
	
	//If we try to access multiplier outside it will be an error
	//int age2 = multiplier;
	
	public static void main(String args[]) {
		ScopesExample se1 = new ScopesExample();
		ScopesExample se2 = new ScopesExample();
		
		System.out.println(se1.species);
		
		se1.species = "dog";
		
		System.out.println(se2.species);
	}

}
