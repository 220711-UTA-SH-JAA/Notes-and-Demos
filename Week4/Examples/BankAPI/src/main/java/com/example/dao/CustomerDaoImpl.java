package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Customer;
import com.example.utils.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao{

	ConnectionUtil conUtil = ConnectionUtil.getInstance();
	
	@Override
	public void createCustomer(Customer c) throws SQLException {
		
		Connection connection = conUtil.getConnection("bankdb");
			
		String sql = "INSERT INTO customer(first_name, last_name, username, password) VALUES (?,?,?,?)";
			
		PreparedStatement p = connection.prepareStatement(sql);
			
		p.setString(1, c.getFirstName());
		p.setString(2, c.getLastName());
		p.setString(3, c.getUsername());
		p.setString(4, c.getPassword());
			
		p.execute();
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = new ArrayList<>();
		Connection connection = conUtil.getConnection("bankdb");
		
		try {
			
			Statement s = connection.createStatement();
			
			String sql = "SELECT * FROM customer";
			
			ResultSet results = s.executeQuery(sql);
			
			while(results.next()) {
				//For each result in the result set, create a new customer object, and add it to the list
				customers.add(new Customer(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public void updateCustomer(Customer c) throws SQLException{

		Connection connection = conUtil.getConnection("bankdb");
		
		String sql = "UPDATE customer SET first_name=?, last_name=?, username=?, password=? WHERE customer_id=?";
		
		PreparedStatement p = connection.prepareStatement(sql);
		
		p.setString(1, c.getFirstName());
		p.setString(2, c.getLastName());
		p.setString(3, c.getUsername());
		p.setString(4, c.getPassword());
		p.setInt(5, c.getCustomerId());
		
		p.execute();
		
	}

	@Override
	public void deleteCustomer(int id) {
		Connection connection = conUtil.getConnection("bankdb");
		
		try {
			
			String sql = "DELETE FROM customer WHERE customer_id=?";
			
			PreparedStatement p = connection.prepareStatement(sql);
			
			p.setInt(1, id);
			
			p.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
