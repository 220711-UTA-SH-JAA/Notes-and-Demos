/* Declare that it is in a package
 * This will tell java, when we compile with a special flag, to create the class in a package in the build folder
 * This will be a class in the com.revature package
 * the package declaration MUST be the first line of the file if its stored in a packge
 * We use the reverse domain naming structure
 * 	com.company.whateverpackage
 * 	they should ALWAYS be all lowercase
 */
package com.revature;

/* We can import other modules/classes into any other class with their fully qualified class name
 * 	packagename.Classname
 */

//import keyword will import the contents of the package specified
//you can import all the classes in a package with the * wildcard
//import java.utils.*;
import com.revature.word.Word;

class Driver{
	public static void main(String args[]){

		Integer number1 = Integer.parseInt(args[0]);

		Integer number2 = Integer.parseInt(args[1]);

		System.out.println("You inputed these numbers: " + number1 + " " + number2);

		System.out.println("Here is your sum: " + (number1 + number2));

		//System.out.println("Printing from a package");

		//Word w = new Word('h','e','l','l','o');

		//System.out.println(w);
	}
}
