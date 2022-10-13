package com.example.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Employee;
import com.example.services.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	private EmployeeService eServ;
	
	@Autowired
	public EmployeeController(EmployeeService eServ) {
		this.eServ = eServ;
	}
	
	@PostMapping("/register")
	Employee register(@RequestBody Employee e) {
		
		return eServ.registerEmployee(e);
		
	}
	
	@PostMapping("/login")
	ResponseEntity<Object> login(@RequestBody LinkedHashMap<String, String> body) {
		String email = body.get("email");
		String password = body.get("password");
		
		Employee e = eServ.loginEmployee(email, password);
		
		if(e == null) {
			return new ResponseEntity("Unable to log in", HttpStatus.UNAUTHORIZED);
		}else {
			return new ResponseEntity(e, HttpStatus.OK);
		}
	}
	
	@PostMapping("/manager")
	Boolean isManager(@RequestBody LinkedHashMap<String, String> body) {
		System.out.println("Request made it");
		Integer id = Integer.parseInt(body.get("id"));
		return eServ.getEmployee(id).isManager();
	}

}
