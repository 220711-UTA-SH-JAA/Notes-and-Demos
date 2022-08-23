package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.Employee;

public class EmployeeDaoMock implements EmployeeDao{

	@Override
	public List<Employee> selectAllEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "Ryan", "Ducolon", "rd", "password", false, new HashSet<>()));
		employees.add(new Employee(2, "Gela", "Kuchaidze", "gk", "password", false, new HashSet<>()));
		employees.add(new Employee(3, "Ethan", "McGill", "em", "password", true, new HashSet<>()));
		
		return employees;
	}

	@Override
	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
