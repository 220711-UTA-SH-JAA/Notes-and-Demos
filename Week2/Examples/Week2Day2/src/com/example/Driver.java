package com.example;

public class Driver {
	
	public static void main(String args[]) {
		
		int number = 23;
		
		String name = "bob";
		
		Person p = new Person(number, name);
		
		p.sayHello();
		
	}
	

}

class Person {
	
	int age;
	
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name =name;
	}
	
	void sayHello() {
		System.out.println("Hello");
	}
	
}
