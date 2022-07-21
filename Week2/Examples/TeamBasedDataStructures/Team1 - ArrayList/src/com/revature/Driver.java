package com.revature;

import com.revature.datastructure.MyArrayList;

public class Driver {

	public static void main(String args[]) {

		System.out.println("Testing instantiation of object and adding items");
		MyArrayList<String> Test = new MyArrayList<>();
		Test.add("cars");
		Test.add("trucks");
		Test.add("boats");
		Test.add("motorcycles");
		Test.add("scooters");
		Test.add("bikes");
		System.out.println(Test);
		
		System.out.println("");
		System.out.println("Testing adding of object at specified index");
		Test.add(3,"Go-kart");
		System.out.println(Test);

		System.out.println("");
		Boolean remove = Test.remove("cars");
		System.out.println("Testing Removal of object");
		if(remove) System.out.println(Test);
		else System.out.println("Object not found in list");

		System.out.println("");
		System.out.println("Testing if object is in list");
		Boolean isIn  = Test.contains("test");
		if(isIn) System.out.println("test was found in list");
		else System.out.println("test was not found in list");

		isIn = Test.contains("trucks");

		if(isIn) System.out.println("trucks was found in list");
		else System.out.println("trucks was not found in list");

	}
	
}
