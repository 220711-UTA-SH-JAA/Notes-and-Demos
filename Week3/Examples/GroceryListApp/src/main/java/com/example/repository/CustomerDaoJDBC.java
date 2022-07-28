package com.example.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Customer;
import com.example.utils.JDBCConnectionUtil;

public class CustomerDaoJDBC implements CustomerDao{
	
	//We first need our connection so we can actually make queries
	JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void createCustomer(Customer c) {
		//Use Statement to create a new user
		try {
			//Get our connection from the driver mananger
			Connection connection = conUtil.getConnectionThroughENV();
			
			//Create the sql query we want to run
			String sql = "INSERT INTO customer (first_name, last_name, username, email, password)"
					+ "VALUES('" + c.getFirstName() + "','" + c.getLastName() + "','" + c.getUsername() + "','"
							+ c.getEmail() + "','" + c.getPassword() + "')";
			
			//Get our statement object from the connection
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> readAllCustomers() {
		
		List<Customer> customers = new ArrayList<>();
		
		try {
			
			//Get our connection from the driver mananger
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "SELECT * FROM customer";
			
			Statement statement = connection.createStatement();
			
			//The select query will return data, so we need to store in a ResultSet
			//ResultSet will essentially, return a collection of all the rows from our query
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Customer c = new Customer();
				//JDBC/SQL indexes from 1
				//This will be the indexes from our result set
				c.setCustomerId(result.getInt(1));
				c.setFirstName(result.getString(2));
				c.setLastName(result.getString(3));
				c.setUsername(result.getString(4));
				c.setEmail(result.getString(5));
				c.setPassword(result.getString(6));
				customers.add(c);
			}
	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return customers;
	}

	@Override
	public Customer readByUsername(String username) {
		//Typically, you could use this to see if the user exists when they attempt signing in
		
		Customer customer = null;
		
		try {
			
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "SELECT * FROM customer WHERE username='" + username + "'";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			//Something to note, our username is unique in the database, so we should only ever retrieve one or none
			while(result.next()) {
				customer = new Customer();
				
				customer.setCustomerId(result.getInt(1));
				customer.setFirstName(result.getString(2));
				customer.setLastName(result.getString(3));
				customer.setUsername(result.getString(4));
				customer.setEmail(result.getString(5));
				customer.setPassword(result.getString(6));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public void updateCustomer(Customer c) {
		//We are going to make one assumption, the user will never be able to change their id
		try {
			
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "UPDATE customer SET "
					+ "first_name = '" + c.getFirstName() + "', "
					+ "last_name = '" + c.getLastName() + "', "
					+ "username = '" + c.getUsername() + "', "
					+ "email = '" + c.getEmail() + "', "
					+ "password = '" + c.getPassword() + "' "
					+ "WHERE customer_id = " + c.getCustomerId();
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(int id) {
		
		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			Statement statement = connection.createStatement();
			
			String sql = "DELETE FROM customer WHERE customer_id = " + id;
			
			statement.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
