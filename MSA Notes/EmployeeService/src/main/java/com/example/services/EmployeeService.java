package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Employee;
import com.example.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	private EmployeeRepository eRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	public Employee registerEmployee(Employee e) {
		
		String email = e.getEmail();
		
		Employee search = eRepo.findByEmail(email);
		
		if(search != null) {
			//The user already exists with that email, do not want to create the user
			return null;
		}
		
		System.out.println(search);
		
		return eRepo.save(e);
		
	}
	
	public Employee loginEmployee(String email, String password) {
		Employee search = eRepo.findByEmail(email);
		
		if(search != null && search.getPassword().equals(password)) {
			return search;
		}
		
		return null;
	}
	
	public Employee getEmployee(Integer id) {
		return eRepo.findById(id).get();
	}

}
