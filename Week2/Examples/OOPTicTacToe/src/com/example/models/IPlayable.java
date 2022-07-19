package com.example.models;

//Interfaces are contracts for methods that a class must implement, interfaces also cannot be instantiated directly
//All interface are implicitly public and abstract
//Every method inside of an interface is also public and abstract
//Interfaces CAN have variables, and they will be public static final
//Technically, since Java 8, there is ONE way to add implementation to a method in an interface, and that is with the
//default keyword
interface IPlayable {

	//this converts to public abstract void play();
	void play();
	
}
