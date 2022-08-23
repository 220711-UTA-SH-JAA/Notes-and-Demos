package com.example.dao;

import java.util.List;

import com.example.models.Employee;

public interface EmployeeDao {
	
	List<Employee> selectAllEmployees();
	void createEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(Employee e);

}
