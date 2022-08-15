package com.example.models;

public class Employee {
	
	public String name;
	
	public void work() {
		
		for(int i=0; i<10; i++) {
			try {
				System.out.println(name + " doing some work...");
				//In this case, the method will be running on the main thread, so the main thread will sleep
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
