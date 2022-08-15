package com.example.threads;

import java.util.List;

public class ManagerRunnable implements Runnable{
	/* The otherway of creating a thread, is by implementing the Runnable interface, this will give you the freedom
	 * to extends any other class you may need
	 * 
	 * To create a thread this way you will:
	 * 1. Create a class the implements Runnable
	 * 2. Implement the run() method
	 * 3. You have to create a new Generic Thread object, and pass the runnable object to that constructor
	 * 4. Use the start() on that Generic Thread object
	 * 
	 */
	
	public List<EmployeeThread> employees;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(EmployeeThread e : employees) {
			System.out.println("Get to work: " + e.getName());
		}
		
	}

}
