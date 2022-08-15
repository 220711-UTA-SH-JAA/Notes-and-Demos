package com.example.models;

import java.util.List;

public class Manager {
	
	public String name;
	
	public void motivateWorkers(List<Employee> employees){
		
		for(Employee e: employees) {
			System.out.println("Get to work " + e.name);
		}
		
	}
}
