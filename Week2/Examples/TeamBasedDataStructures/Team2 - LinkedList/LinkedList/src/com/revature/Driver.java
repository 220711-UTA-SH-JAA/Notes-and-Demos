package com.revature;


public class Driver {
	
	public static void main(String[] args) {
		
		//creating a LinkedList object
		LinkedList numbers = new LinkedList();
		
		//adding numbers to the LinkedList from the end of the list
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		
		//printing out the list of numbers. We know that it isnt pretty
		System.out.println(numbers);
		System.out.println("Size: " + numbers.getSize());
		
		//deleting the number that is at index 3
		numbers.removeAtPosition(numbers, 3);
		
		//printing out the new list of numbers
		System.out.println(numbers);
		System.out.println("Size: " + numbers.getSize());
		
		
		
		

		
	}

}
