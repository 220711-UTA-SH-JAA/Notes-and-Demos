package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Employee;
import com.example.models.Manager;
import com.example.threads.EmployeeThread;
import com.example.threads.ManagerRunnable;

public class ThreadsDriver {
	
	public static void main(String args[]) {
		/* Normal java code behavior, this will run line by line, and only move on when finished */
		List<Employee> employeeList = new ArrayList();
		
		Employee e1 = new Employee();
		e1.name = "Employee 1";
		
		Employee e2 = new Employee();
		e2.name = "Employee 2";
		
		employeeList.add(e1);
		employeeList.add(e2);
		
		Manager m = new Manager();
		m.name = "Ethan";
		
		/* Lets observe how the code operates without threads */
		e1.work();
		m.motivateWorkers(employeeList);
		e2.work();
		
		/* Optimize with threads */
		System.out.println("... Using Threads ...");
		
		//To create a thread that extends the Thread class
		EmployeeThread et1 = new EmployeeThread();
		et1.setName("Employee Thread 1");
		
		EmployeeThread et2 = new EmployeeThread();
		et2.setName("Employee Thread 2");
		
		List<EmployeeThread> ets = new ArrayList<>();
		ets.add(et1);
		ets.add(et2);
		
		//To create a thread from a class which implements Runnable
		ManagerRunnable mr = new ManagerRunnable();
		mr.employees = ets;
		
		//Create generic thread, and pass the runnable object to that constructor
		Thread managerThread = new Thread(mr);
		
		//Start the threads
		et1.start();
		et2.start();
		
		//While the threads are still active/alive/executing, lets have the manager motivate them
		while(et1.isAlive() && et2.isAlive()) {
			try {
				Thread.sleep(3000);
				managerThread.run();
				managerThread.join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			//When the thread is finished, close it/get rid of it/ terminate it
			et1.join();
			et2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
