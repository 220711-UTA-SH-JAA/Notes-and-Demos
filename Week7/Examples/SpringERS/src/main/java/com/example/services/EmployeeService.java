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
	private EmployeeDao eDao;
	
	//We will inject this one through a constructor
	//We need to mark our constructor, as being autowired
	@Autowired
	public EmployeeService(EmployeeDao eDao) {
		this.eDao = eDao;
	}
	
	public void printAllEmployees() {
		List<Employee> allEmployees = eDao.selectAllEmployees();
		
		for(Employee e: allEmployees) {
			System.out.println(e);
		}
	}

}
