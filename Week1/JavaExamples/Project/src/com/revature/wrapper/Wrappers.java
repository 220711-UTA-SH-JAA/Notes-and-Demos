package com.revature.wrappers;

public class Wrappers{

	/* The only thing keeping java from being perfectly object oriented is the primitives
	 * 
	 * To push a more Object Oriented Approach java created Wrapper classes
	 *
	 * Classes to be used instead of the primitive types
	 *
	 * Each primitive type has its own wrapper class which is named the same except with an upper case
	 *	Allow us to treat primitives as objects
	 *	We use them with generics
	 *	Have useful methods for converting from strings and other types to their type
	 *	- Useful in your exercise today
	 *
	 * With wrapper there are two conversions that java will do automatically when using wrappers with methods
	 *
	 * Autoboxing: when you pass a primitive value to a method expecting a wrapper, the method will automatically convert the primitive to its
	 * wrapper equivalent
	 *
	 * Unboxing: when you pass a wrapper to a method that expexts a primitive, java will automatically convert to its primitive equivalent
	 */

	Boolean hitOrMiss = true;

	Byte littleBits = 24;

	Short kendrick = 53;

	Character payRespects = 'f';

	Integer number = 12354;

	Long longerNumber = 12344568778;

	Float decimalPoint = 3.14;

	Double fiftyCent = 0.5;

}	
