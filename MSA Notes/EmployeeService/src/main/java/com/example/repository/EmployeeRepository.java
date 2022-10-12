package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public Employee findByEmail(String email);
}
