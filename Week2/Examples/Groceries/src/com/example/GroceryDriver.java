package com.example;

import java.util.Scanner;

public class GroceryDriver {
	
	public static void main(String args[]) {
		
		boolean done = false;
		
		//Make a very simple UI using the terminal
		try(Scanner scan = new Scanner(System.in)){
			
			//Loop forever
			while(!done) {
				
				/* Actual application implentation up here */
				
				
				
				//Ask the user if they are finished
				System.out.println("Are you done? Y/N");
				String in = scan.nextLine();
				
				//If they are finished, done -> true, and the while will see !true and exit
				if(in.equals("Y")) {
					done = true;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
