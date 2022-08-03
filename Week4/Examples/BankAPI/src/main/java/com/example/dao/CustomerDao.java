package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Customer;

public interface CustomerDao {
	
	void createCustomer(Customer c) throws SQLException;
	
	List<Customer> getAllCustomers();
	
	void updateCustomer(Customer c) throws SQLException;
	
	void deleteCustomer(int id);

}
