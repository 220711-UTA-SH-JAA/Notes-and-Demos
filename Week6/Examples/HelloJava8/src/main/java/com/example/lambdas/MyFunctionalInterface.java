package com.example.lambdas;

/*	Functional Interfaces
 * 	- Are interfaces with only on abstract method
 * 	- This one abstract method is meant to be implemented by a lambda
 * 	- Implicitly created by some lambda expressions
 */

//Make a generic functional interface, that can return any type
@FunctionalInterface
public interface MyFunctionalInterface<T> {
	
	//Singular method which can be implemented in any class using a lambda
	//This special interface, with the use of lambdas allows us to be more functional in java rather than oop
	T execute();

}
