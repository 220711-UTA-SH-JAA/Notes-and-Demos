package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.example.models.GroceryItem;

public class CollectionsDriver {
	
	public static void main(String args[]) {
		
		/*
		 * Collection API is a framework of classes and interfaces in Java, that implement our most commonly
		 * used data structures 
		 * - These will primarily be linear
		 * 
		 * Collection API it be viewed as a hierarchy, and each interface that implements Collection is a part of it
		 * - List
		 * - Set
		 * - Queues
		 * - *Map (Map is technically not a part of the collection api for one reason)
		 * 
		 */
		
		//List (Interface): The most basic datastructure, a collection of ordered data, the order will be preserved
		// - Duplicate elements are allowed
		// - Elements are accessed by their index starting at 0
		//Lets see some List implementations
		
		//ArrayList
		
		/*
		 * Inside of the <> we can specify an object to be stored in this array list
		 * - This notation is for Generics
		 * 
		 * Generics are a Java construct which enforce compile time safety, by allowing the use of paremeterized types
		 * - They are placeholders for future values
		 * - Once the Generic type has been set, it cannot change
		 * 
		 * Generics can be declared on classes, methods, and returns types, and technically variables
		 * - With these as we have seen, we can restrict a class to only take in some type of data, the compiler
		 * 		will restrict from using anything else
		 * 
		 * To make a class or interface Generic, you use the angled on the class/interface declaration
		 * MyClass<T>, then when you declare a new instance you would pass the datatype in
		 * 	MyClass<String>
		 * 
		 */
		System.out.println("--- ArrayList ---");
		ArrayList<GroceryItem> gAL = new ArrayList<>();
		
		//To test that the compiler will restrict us from using any other type lets try passing in a string
		//groceriesArrayList.add("Hello");
		gAL.add(new GroceryItem("Chicken", 23.00, "Meat"));
		gAL.add(new GroceryItem("Tide Pods", 18.00, "Snack"));
		
		System.out.println(gAL);
		//Get a specific index gAL.get()
		System.out.println(gAL.get(1));
		
		//To remove a specific item
		gAL.remove(1);
		
		System.out.println(gAL);
		
		//There is also a .size method that can be used to loop through the list similarly to an array
		
		//Linked List - Implementation of List and Queue
		
		System.out.println("--- LinkedList ---");
		LinkedList<GroceryItem> lGL = new LinkedList<>();
		
		/* ALMOST every interface of the collection API extends the Iterable interface
		 * 	- Except for the Map interface
		 * 
		 * Iterable interface:
		 * - Mark a class as being iterable, we can use an iterator to iterate through it
		 * 
		 * Iterator interface:
		 * - contains methods for traversing linear data structures, these include:
		 * 		- hasNext()
		 * 		- next()
		 * 		- remove()
		 * 
		 * Any class that implements Iterable can be used with enhanced for loops and forEach loops
		 * 
		 */
		
		lGL.add(new GroceryItem("Ground Beef", 3.99, "Meat"));
		lGL.add(new GroceryItem("Snickers", 1.99, "Snack"));
		lGL.add(new GroceryItem("Coke Zero", 1.99, "Beverage"));
		
		//Loop through with an iterator
		//When you don't how long the list will be, or if you may be doing something multithreaded, and other methods
		//May add while you are looping
		Iterator<GroceryItem> groceryIterator = lGL.iterator();
		
		//To loop through our linked list, we will use a while loop
		while(groceryIterator.hasNext()) {
			//Every time we call next, it actually pushed the iterator one index forward
			GroceryItem gi = groceryIterator.next();
			System.out.println(gi);
			//Lets say we want to get rid of all items > 1.99
			/*
			if(gi.getValue() > 1.99) {
				lGL.remove(gi);
			}
			*/
		}
		
		System.out.println(lGL);
		
		//Adding/removing/modifying will primarily be the same as ArrayList, and refer to the documentation for more details
		
		/*
		 * There are a couple more List implementations that you may see in the wild
		 * - Vector: this is an older implementation of an ArrayList, it is threadsafe, and it doubles the array size
		 * - Stack: this implementation for the Stack datastructure, now we use Deque
		 */
		
		/*
		 * Sets:
		 * - A collection of data that is NOT ordered, and will not contain duplicates
		 * 		- does not preserve the order in which you inserted
		 */
		
		//HashSet, allows for one null value, and it has fast insertion and traversal
		//Useful when you don't want duplicates
		System.out.println("--- HashSet ---");
		HashSet<GroceryItem> gHS = new HashSet<>();
		
		gHS.add(new GroceryItem("Pork Chops", 9.99, "Meat"));
		gHS.add(new GroceryItem("Pork Chops", 9.99, "Meat"));
		gHS.add(new GroceryItem("Pork Chops", 9.99, "Meat"));
		gHS.add(new GroceryItem("Pop Rocks", .99, "Candy"));
		
		System.out.println(gHS);
		
		//Enhanced for-loop
		//This is saying for all grocery items in grocery HashSet
		for(GroceryItem gi: gHS) {
			//The downside is that you do not have access to the index
			System.out.println(gi);
			if(gi.getValue() > .99) {
				System.out.println("We could do some logic on: " + gi);
			}
		}
		
		/*
		 * Queue, is a collection of data that follows first in first out
		 */
		
		//ArrayDeque is an implementation of both the Queue and Deque interfaces
		//Double ended queue
		// - It can be treated as a stack or a queue
		//	- This implementation uses a resizable array
		System.out.println("--- ArrayDeque ---");
		ArrayDeque<GroceryItem> gAD = new ArrayDeque<>();
		
		//On the beginning
		gAD.push(new GroceryItem("Chicken", 28.00, "Meat"));
		//On the end
		gAD.addLast(new GroceryItem("Lettuce", 2.99, "Produce"));
		//On the beginning
		gAD.push(new GroceryItem("Steak", 24.99, "Meat"));
		//On the end
		gAD.addLast(new GroceryItem("Carrots", 2.99, "Produce"));
		
		System.out.println(gAD);
		
		gAD.removeFirst();
		gAD.removeLast();
		
		System.out.println(gAD);
		
		/* Priority Queue: a class the implements the Queue interface, which orders elements based on a Comparator */
		
		/* Maps
		 * - Are a data structure that use key values pairs to store and retrieve data
		 * 
		 * The Map interface does NOT implement the Collection interface, however, it still considered part of the 
		 * Collection API
		 * - It also does NOT implement Iterable, so Maps cannot be directly iterated over
		 * 		- But if you wanted to iterate over either the values or the keys you can
		 * 		- entrySet()
		 * 		- keySet()
		 * 		- values()
		 */
		
		//Hashmap is popular because they are very fast at adding, and searching for items
		//TLDR is when you add an item to a hashmap, the key gets converted into a hash, and then value is stored
		//either at that memory address, or in an array at the index
		//HashMap will allow you to store one null key, and one null value
		System.out.println("--- Hashmap ---");
		//<Key, Value>
		HashMap<String, GroceryItem> gHM = new HashMap<>();
		
		//To add values
		gHM.put("Ground Beef", new GroceryItem("Ground Beef", 3.99, "Meat"));
		gHM.put("Chicken", new GroceryItem("Chicken", 29.00, "Meat"));
		
		System.out.println(gHM.get("Ground Beef"));
		
		//.values returns a generic Collection, so then you must iterator from there
		Iterator<GroceryItem> giIterator = gHM.values().iterator();
		while(giIterator.hasNext()) {
			System.out.println(giIterator.next());
		}
		
		//.keySet will return a set of keys that are stored in the HashMap
		Iterator<String> keyIterator = gHM.keySet().iterator();
		while(keyIterator.hasNext()) {
			System.out.println(keyIterator.next());
		}
		
		/*
		 * TreeMap: store the values in a tree structure
		 * - Cannot contain null keys, but a null value is allowed
		 * 
		 * Hashtable: Cannot store null keys OR null values
		 */
		
		
		
	}

}
