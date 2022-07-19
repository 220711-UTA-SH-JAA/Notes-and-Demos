
/* Multiline comments can be made with the /*
 *
 */
//Single line comments are with //

/*
 * Our java applications are broken up into classes
 * Describe what our objects look like
 *
 * Objects are simply an instance of our class that we can create
 */
//The class keyword is creating a class, and HelloJava names the Object
//If we wanted a dog class you would put class Dog{}
class HelloJava{

	//Methods
	//A named block of code, which can called anywhere
	//We must have an instance of our object to call it, or it must be called inside of the objects class
	//To start the method we have some modifiers, more on these later
	//Then you must assign a return type (datatypes in java)
	//Remember that Java is statically typed, so every must have a type at compile
	//The method needs a name, in this case it is called main
	//Inside of the parenthesis you can have 0 or more parameters
	//For this specific method, we are passing in an array of strings
	//This main method is special, you must have one if you want to run your program, the entry point/where you program will be run
	//The reason its called main, is because thats what the java developers wanted to call
	//Its always going to have the same syntax, so remember it
	public static void main(String args[]){
		//Then inside of the body of the method, we have the logic/functionality
		//System is a class of the java.lang package (gets imported automatically)
		//out is a variabale inside of System
		//println is a method which prints whatever parameters to the console

		System.out.println("Hello Java");
		System.out.println("Printing another line to the console");

		/*
		 * Above we mentioned that all methods must have a return type, this means that methods have the ability to return some peice of data
		 * To do so we use the keyword return
		 */

	}
}
