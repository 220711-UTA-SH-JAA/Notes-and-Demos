package com.example.threads;

public class EmployeeThread extends Thread{
	/* Custom Threads, we are able to create our own threads in two ways, either extending the Thread class or
	 * Implementing the Runnable interface
	 * 
	 * Extending the Thread class:
	 * This method, will grant us access to a bunch of pre-implemented methods specifically for threads
	 * - getters and setters for id, name, and priority
	 * - interrupt() to specificaly interrupt the thread
	 * - isAlive(), isInterrupted(), isDaemon() to test the state of the thread
	 * - join() to wait for thread to finish executing, then terminate
	 * - start() to actually run the logic for the thread
	 * 
	 * The downside, is that you cannot extend any other classes in java
	 * 
	 * To create our thread we need to:
	 * 1. Create a class and extend Thread
	 * 2. Implement the run() method
	 * 3. Create an instance of our thread, and call start
	 */

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				System.out.println(this.getName() + " doing some work...");
				//In this case, we are actually running a separate thread from main, so this particular employee thread
				//will sleep, not the main thread
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
