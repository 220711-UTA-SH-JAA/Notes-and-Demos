package com.example.gc;

public class GarbageCollection {
	
	/*
	 * Java will automatically remove object from memory when no longer needed/when they have no reference to them anymore
	 * 
	 * You cannot explicitly call for garbage collection, but can suggest
	 * 	- System.gc()
	 * 	- Runtime.getRuntime().gc()
	 *  - System.runFinalize()
	 *  	- Finalize is an inherited method from the Object class (more on this tomorrow) that you can override and run some logic before the object destroyed
	 */
	
	public static void main(String args[]) {
		
		//1. We will create a new object in memory and call it var1
		CollectMe var1 = new CollectMe();
		
		//2. We will create another new object in memory and call it var2
		CollectMe var2 = new CollectMe();
		
		//3. We will create a variable var3 and reference var1
		CollectMe var3 = var1;
		
		//4. Reference var2 to var 3, then the second object will no longer have a variable referencing it, and now its time for garbage collection noises
		var2 = var3;
	}
	

}

class CollectMe {
	
	public void finalize() {
		System.out.println("Goodbye cruel world *Garbage Collector Noises*");
	}
	
}
