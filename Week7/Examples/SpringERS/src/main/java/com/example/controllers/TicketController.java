package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Employee;
import com.example.models.Ticket;
import com.example.services.EmployeeService;
import com.example.services.TicketService;

//One more annotation I want you all to know
//@RestController combines the @Controller and @ResponseBody, meaning you no longer need to provide @Response body infront of every
//method
@RestController()
@RequestMapping("/tickets")
public class TicketController {

	private TicketService tService;
	private EmployeeService eService;
	
	@Autowired
	public TicketController(TicketService tService, EmployeeService eService) {
		this.eService = eService;
		this.tService = tService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> createTicket(@RequestBody LinkedHashMap<String, String> body){
		
		String username = body.get("username");
		
		Employee submitter = eService.getByUsername(username);
		
		if(submitter == null) {
			return new ResponseEntity<>("User must exist to create ticket", HttpStatus.FORBIDDEN);
		}
		
		String desc = body.get("description");
		Double amount = Double.parseDouble(body.get("amount"));
		String type = body.get("type");
		
		tService.createTicket(desc, amount, type, submitter);
		
		return new ResponseEntity<>("Ticket was created successfully", HttpStatus.CREATED);
		
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "an exception occured";
	}
	
}
