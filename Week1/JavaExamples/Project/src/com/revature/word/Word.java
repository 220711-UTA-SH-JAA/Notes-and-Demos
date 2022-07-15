package com.revature.word;

public class Word{
	
	/*
	 * Arrays and Array Indexing in Java
	 * Most basic object type in java, and it stores data of the same type
	 * But these can store ANY java datatype including objects and primitives
	 * The elements in the array are stored in indexes
	 * 	- The arrays are stored in contigous memory blocks, meaning, they are physically located next to each other in memory
	 * 	- The array indexes start at 0
	 * We can access each individual element of an array by its index, and this relatively quick
	 * The array MUST be given a size when instantiated, and it cannot be resized
	 * The length attribute/property which will return the size of the array
	 */

	//The array will need a datatype, it will need a name like a regular variable, the only difference is you include square brackets
	//The square brackets can go after the datatype or after the variable name
	
	//Declcare your array
	//char[] characters;
	//char characters[];
	
	//To instantiate
	//char[] characters = new char[size]
	//char[] characters = {'a','b','c'}
	//This would be illegal
	//char[] characters = {'g', 4, 5.9, 'f'}
	
	//Java allows objects to reference other objects, so this means that multi-dimensional arrays are possible
	//These form a matrix structures
	//char[][] multiArray = [size][size]

	//For our case, we want java to start out us out with an empty word aka an empty array
	public char[] characters;

	public int size;

	/* Constructors
	 * Are special methods that allow you to instantiate object types in java
	 * 	They don't return type, they just return a new object
	 * 	Share the name of the class/object being created
	 * 	We can give specific values to be set inside of our object
	 * The different types of constructors
	 * 	Default: a constructor that the java compiler automatically creates for you if you did not specify a constructor in the class
	 * 	No argument: a constructor that the developer writes that takes in no parameters,
	 * 		- As soon as you write ANY constructor, the default construtcor is no longer created
	 * 		- The no args and the default are NOT the same
	 * 	Argument/Parameterized: a constructor that takes in one or more arguments
	 *
	 * You may see the this keyword used in constructors
	 * 	- The this keyword refers to the variable in THIS object, often used to set variables inside of argument constructors
	 *
	 * You may see the super() keywods used in a constructor
	 * 	- This is called regardless of if its included
	 * 	- The super() keyword calls the constructor of the parent class (more on this in inheritance)
	 * 	- The first line of every constructor
	 *
	 * You may see the this() keyword in a constructor
	 * 	- This is used for constuctor chaining
	 * 	- This will essentially call upon another constructor inside of the class
	 */

	public Word(){
		System.out.println("We called the no args constructor");
		size=0;
		characters = new char[0];
	}

	//The ... is a special notation for something called varags
	//Var args means variable argumens, meaning we can pass in as many characters as we want
	//And this varargs will be converted into an array of that datatype
	//Allows us to have an undefined number of values passed in
	//You are only allowed one varargs per method
	//You can have other parameters, but the varargs must be the last parameter passed in
	
	/*ILLEGAL VARARGS*/
	//Word(char ...characters, int ...numbers)
	//Word(char ...characters, int number)
	
	/* LEGAL VARARGS */
	//Word(char ..characters)
	//Word(int number, char... characters)
	public Word(char ...characters){
		//This is not neccessary, but it is called the no argument constructor of the Word class
		this();
		System.out.println("Inside of the arguments constructor");
		//we are setting the objects character array to the array spit out from varargs
		this.characters = characters;
		size = characters.length;
	}


	public Word concatenate(char ...chars){

		//We cant resize the characters array because its an array
		//We need to make a new array to add the old characters and the new characters
		//We length of the size of the old character array + length of the size of the new characters
		char[] newWord = new char[characters.length + chars.length];

		//Loop through every index of the new array
		for(int i=0; i<newWord.length; i++){
			if(i<characters.length){
				newWord[i] = characters[i];
			} else {
				newWord[i] = chars[i - characters.length];

			}

		}

		return new Word(newWord);
		
	}

	public int charAt(int index){
		if(index > characters.length || index < 0){
			return -1;
		}

		return characters[index];
	}

	public boolean contains(Word word){

		//Brute force idea
		//Get the first char of the word parameter
		//And loop until we find it
		//If we find go to the next one and see if we see that in our word otherwise go back to the first index of the given word

		//w = racecar
		//w.contains(car) return true
		
		int countedChars = 0;

		//Looping through the entire characters array of THIS object
		for(int i=0; i<this.characters.length; i++){
			//If we match the first character of the work we are looking for do some logic to check the rest
			if(word.characters[0] == this.characters[i]){
				System.out.println("input char: " + word.characters[0] + " this char: " + this.characters[i]);
				//We start at index 1, because we have already matched index 0 of words.characters
				//Loop through the word we passed in as a parameter
				countedChars = 1;
				//We look at each of the characters left in the word and see if they match with THIS word
				if(i+word.characters.length > this.characters.length){
					return false;
				}
				for(int j=1; j<word.characters.length; j++){
					if(word.characters[j] == this.characters[i+j]){
						//If they do, we increment the number of mathces we have seen
						System.out.println("input char: " + word.characters[j] + " this char: " + this.characters[i+j]);
						countedChars++;
					} else {
						//Other we reset the counter because the character didn't match
						countedChars = 0;
						break;
					}
				}

				//See if we matched the correct amount of characters
				if(countedChars == word.characters.length){
					return true;
				}
			}

		}
		return false;

	}

}
