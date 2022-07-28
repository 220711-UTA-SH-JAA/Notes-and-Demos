package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.exceptions.CustomerDoesNotExistException;
import com.example.models.Customer;
import com.example.models.Item;
import com.example.repository.CustomerDao;
import com.example.repository.CustomerDaoJDBC;
import com.example.repository.ItemDao;
import com.example.repository.ItemDaoJDBC;
import com.example.services.CustomerService;
import com.example.services.ItemService;
import com.example.utils.JDBCConnectionUtil;

public class JDBCDriver {
	
	/*
	 * Intro to JDBC (Java Database Connectivity): Allow us to write java code that interacts with relational databases
	 * 
	 * The classes and interfaces we will interact with:
	 * DriverManager class: allow us to make a connection to the database
	 * DataSource interface: for retrieving connections, an alternative to DriverManager
	 * Connection interface: a physical connection to the database (how we will actually make queries from the our code)
	 * SQLException class: a general exception that gets thrown when something goes wrong with your SQL
	 * Statement interface: used to execute static queries to our database (get this from the connection)
	 * 	- Get the Statement from the connection
	 * 	- Input the query you would like to run to the Statement
	 * 	- Execute (get the results)
	 * PreparedStatement interface: precompiled SQL query
	 * 	- Allow for dynamic parameters
	 * 	- Safer than normal Statements, because they prevent SQL injection
	 * 	- Get the PreparedStatement from the Connection
	 * 	- Input the query with any paremeters to the PreparedStatement
	 * 	- Execute and get the results
	 * CallableStatement interface: used to execute stored functions or procedures on the database
	 * 	- Allow for parameterized queries
	 * 	- Safer than normal Statements
	 * 	- Get the CallableStatement from the Connection
	 * 	- Pass it the function from the db you want to call
	 * 	- Execute and get the result
	 * ResultSet interface: represent the data coming back from the query
	 *  - When we execute one of the statements above which returns data, it will return a Collection of rows
	 *  - You must loop through this collection, and make the objects by hand
	 */
	
	private static CustomerDao customerDao = new CustomerDaoJDBC();
	private static CustomerService customerService = new CustomerService(customerDao);
	private static ItemDao itemDao = new ItemDaoJDBC();
	private static ItemService itemService = new ItemService(itemDao);
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		boolean notDone = true;
		
		Customer loggedIn = null;
		
		while(notDone) {
			
			System.out.println("What would you like to do?");
			System.out.println("Press: 1 to register, Press 2: to view all Users, Press 3: to login as a customer, Press 4: To update information");
			System.out.println("Press: 5 to delete a customer, Press 6: To add a new item to the store, Press 7: To view all the items in the store");
			System.out.println("Press: 8 to search for an item by name, Press: 9 to update an item, Press 10: To delete an item");
			
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
				case 1:
					System.out.print("Enter your first name: ");
					String first = input.nextLine();
					System.out.print("Enter your last name: ");
					String last = input.nextLine();
					System.out.print("Enter your username: ");
					String username = input.nextLine();
					System.out.print("Enter your email: ");
					String email = input.nextLine();
					System.out.print("Enter your password: ");
					String password = input.nextLine();
					
					customerService.addNewCustomer(first, last, username, email, password);
					break;
				case 2:
					List<Customer> customers = customerService.getAllCustomers();
					for(Customer c: customers) {
						System.out.println(c);
					}
					break;
				case 3:
					System.out.print("What is your username: ");
					username = input.nextLine();
					try {
						loggedIn = customerService.loginCustomer(username);
						System.out.println("Welcome in: " + loggedIn.getFirstName());
					}catch(CustomerDoesNotExistException e) {
						System.out.println("It doesn't appear this username exists");
					}
					
					break;
				case 4:
					System.out.println("Fill out the areas below that you want updated, just press enter to ignore a field");
					System.out.print("Enter your first name: ");
					first = input.nextLine();
					System.out.print("Enter your last name: ");
					last = input.nextLine();
					System.out.print("Enter your username: ");
					username = input.nextLine();
					System.out.print("Enter your email: ");
					email = input.nextLine();
					System.out.print("Enter your password: ");
					password = input.nextLine();
					
					loggedIn = customerService.updateCustomer(loggedIn, first, last, username, email, password);
					break;
				case 5:
					System.out.print("Please input the id of the user you would like to delete: ");
					int toDelete = input.nextInt();
					input.nextLine();
					customerService.removeCustomer(toDelete);
					break;
				case 6:
					System.out.print("Enter the item name: ");
					String itemName = input.nextLine();
					System.out.print("Enter the item type (MEAT, PRODUCE, BEVERAGE, SNACK, SAUCE, HOUSEHOLD, OTHER): ");
					String itemType = input.nextLine();
					System.out.print("Enter the price: ");
					double price = input.nextDouble();
					input.nextLine();
					itemService.addItem(itemName, itemType, price);
					break;
				case 7:
					List<Item> items = itemService.retrieveAllItems();
					
					for(Item i:items) {
						System.out.println(i);
					}
					break;
				case 8:
					System.out.print("Enter the item name you are looking for: ");
					itemName = input.nextLine();
					System.out.println(itemService.getItemByName(itemName));
					break;
				case 9:
					System.out.print("What item would you like to update: ");
					String oldName = input.nextLine();
					System.out.print("Enter the item name: ");
					itemName = input.nextLine();
					System.out.print("Enter the item type (MEAT, PRODUCE, BEVERAGE, SNACK, SAUCE, HOUSEHOLD, OTHER): ");
					itemType = input.nextLine();
					System.out.print("Enter the price: ");
					String priceString= input.nextLine();
					itemService.updateItem(oldName, itemName, itemType, priceString);
					break;
				case 10:
					System.out.print("What item would you like to delete?");
					int itemId = input.nextInt();
					input.nextLine();
					itemService.removeItemFromStore(itemId);
					break;
				default:
					System.out.println("I didn't understand");
			}
			
			System.out.println("Are you done? Y/N");
			String finished = input.nextLine();
			if(finished.equals("Y")) {
				notDone = false;
			}
			
		}
		
	}

}
