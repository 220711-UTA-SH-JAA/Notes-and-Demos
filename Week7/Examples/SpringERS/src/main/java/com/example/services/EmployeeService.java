package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoMock;
import com.example.models.Employee;

@Service("EmployeeServiceBean")
public class EmployeeService {
	
	//The oldway you might have added the EmployeeDao dependency is like this
	//private EmployeeDao eDao = new EmployeeDaoMock();
	//The purpose of spring, is so we don't have to do the above anymore
	
	//We will just include the dependencies we want
	@Autowired
	private EmployeeDao eDao;
	
	//We will inject this one through a constructor
	//We need to mark our constructor, as being autowired
	public EmployeeService(EmployeeDao eDao) {
		this.eDao = eDao;
	}
	
	public void printAllEmployees() {
		List<Employee> allEmployees = eDao.selectAllEmployees();
		
		for(Employee e: allEmployees) {
			System.out.println(e);
		}
	}

	public Employee saveEmployee(Employee e) {
		
		
		eDao.createEmployee(e);
		
		Employee ret = eDao.selectAllEmployees().stream()
				.filter(employee -> employee.getUsername().equals(e.getUsername()))
				.findFirst().get();

		return ret;
	}

	public Employee login(String username, String password) {
		
		List<Employee> employees = eDao.selectAllEmployees();
		
		for(Employee e: employees) {
			if(e.getUsername().equals(username) && e.getPassword().equals(password)) {
				return e;
			}
		}
		
		return null;
	}

	public Employee getByUsername(String username) {
		List<Employee> employees = eDao.selectAllEmployees();
		
		for(Employee e: employees) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		
		return null;
	}

	public Employee getById(int id) {
		List<Employee> employees = eDao.selectAllEmployees();
		
		for(Employee e: employees) {
			if(e.getEmployeeId() == id) {
				return e;
			}
		}
		
		return null;
	}
	
	

}
