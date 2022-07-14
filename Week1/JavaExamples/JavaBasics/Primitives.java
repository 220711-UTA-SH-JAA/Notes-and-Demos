class Primitive{
	
	/*
	 * In Java we have two types of Data
	 * Primitive & Reference
	 *
	 * Primitive types are our most basic, and reference types are "object"/references to objects in memeory
	 *
	 * Primitivite types include
	 */
	
	//To create variables
	//Varaiables are typically named in camelCase convention firstword is lowercase every other word starts with a Uppercase
	//They need a datatype
	//They need a name
	//They need assignment
	//boolean primitive can be true or false
	//Size in Bits = 1 Bit
	boolean isEmpty = false;
	
	/* These are our whole numbers */

	//byte primitive
	//Size in Bits = 8 bits
	//byte can be between -128 to 127
	byte height = 120;

	//short primitive
	//Size in Bits = 16 bits
	//short can be between -32,768 to 32,767
	short miles = 20_000;

	//int primitive
	//Size in Bits = 32 Bits
	//int can be between -2^31 to 2^31-1
	int people = 1_234_567;

	//long primitive
	//Size in Bits = 64 Bits
	//long can be between -2^63 ro 2^63-1
	//Java tries to convert longs to integers, so you must MAKE java create a long
	//So if you see a number with a l beside it, the developer is forcing java to create a long
	long bugs = 1_234_567_890L;

	/* Floating/decimal numbers in Java */

	//float primitive
	//Size in bits = 32
	//float value range is between -1.4^45 to 3.40^38
	//Java tries to convert things to double, so we must explicitly say no we want a float
	float income = 20.5f;

	//double primitive
	//Size in bits = 64
	//double value can range between -4.9^329 to 1.79^308
	double pi = 3.141592;

	/* Other primitive type */
	//character primitive type a single character
	//16 bit unicode value
	//is to create a character you MUST use '' not ""
	char f = 'f';

	/* Default values for java datatypes
	 *
	 * Numberics (byte, short, int, long): 0
	 * Decimals (float, double): 0.0
	 * Booleans: false
	 * Char: \u0000
	 * Reference/Object: null
	 */

	/*
	 * Casting is technically part of polymorphism
	 * Is the ability to convert/change the datatype of a variable
	 * Two types of casting Widening and Narrowing
	 *
	 * Widening will automatically occur in Java
	 * 	Take a smaller datatype and convert it to a larger one
	 * Narrowing will have to be done explicitly
	 * 	More dangerous because you are taking a larger datatype and attempting to convert it to a smaller one
	 */

	public static void main(String[] args){

		byte b = 16;
		short s = 130;
		int i = 32_768_986;

		//widening
		//To cast we use parenthesis and the datatype we want to cast to
		short widenB = (short)b;

		System.out.println(widenB);

		short narrowI = (short)i;

		System.out.println(narrowI);

	}
	


}
