package com.example;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import com.example.exceptions.ItemNotFoundException;
import com.example.models.GroceryItem;
import com.example.repository.GroceryMockRepo;
import com.example.services.GroceryService;

public class GroceryDriver {
	
	private static GroceryMockRepo repo;
	private static GroceryService groceryService;
	private static DecimalFormat df;
	
	public static void main(String args[]) {
		
		repo = new GroceryMockRepo();
		groceryService = new GroceryService(repo);
		df = new DecimalFormat("0.00");
		
		boolean done = false;
		
		//Make a very simple UI using the terminal
		try(Scanner scan = new Scanner(System.in)){
			
			System.out.println("Welcome to your personal grocery list");
			
			//Loop forever
			while(!done) {
				
				/* Actual application implentation up here */
				System.out.println("Please confirm what you would like do next:");
				System.out.println("1. Add an item to the list");
				System.out.println("2. View your list");
				System.out.println("3. Search for an item in your list");
				System.out.println("4. Remove an item from your list");
				
				int choice = scan.nextInt();
				scan.nextLine();
				
				switch(choice) {
					case 1:
						System.out.print("Please enter the name of your item: ");
						String name = scan.nextLine();
						System.out.print("Please enter the price of the item: ");
						double price = scan.nextDouble();
						scan.nextLine();
						System.out.print("Please enter the item type: ");
						String type = scan.nextLine();
						
						GroceryItem added = groceryService.createNewItem(name, price, type);
						
						System.out.println("The item: " + added + " has been added to your list!");
						
						break;
					case 2:
						//Logic for viewing the list
						List<GroceryItem> items = groceryService.getAllItems();
						
						StringBuilder builder = new StringBuilder();
						
						System.out.println("Your grocery list: " + df.format(groceryService.getCost()));
						
						for(int i=0; i<items.size(); i++) {
							builder.append(i+1);
							builder.append(". ");
							builder.append(items.get(i).getName());
							System.out.println(builder.toString());
							builder = new StringBuilder();
						}
						
						break;
					case 3:
						//Logic for Searching the list
						System.out.print("Please enter the name of your item to find: ");
						name = scan.nextLine();
						
						try {
							GroceryItem search = groceryService.getItemByName(name);
							System.out.println(search);
						} catch(ItemNotFoundException e) {
							System.out.println("We are sorry, the item you are looking for does not exist");
						}
						
						break;
					case 4:
						//Logic for deleting from the list
						System.out.print("Please enter the name of your item to delete: ");
						name = scan.nextLine();
						
						groceryService.deleteItem(name);
						
					default:
						System.out.println("I didn't quite catch that");
						break;
				}
				
				
				//Ask the user if they are finished
				System.out.println("Are you done? Y/N");
				String in = scan.nextLine();
				
				//If they are finished, done -> true, and the while will see !true and exit
				if(in.equals("Y")) {
					done = true;
				}
			}
			
			System.out.println("Thank you for using our app");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
