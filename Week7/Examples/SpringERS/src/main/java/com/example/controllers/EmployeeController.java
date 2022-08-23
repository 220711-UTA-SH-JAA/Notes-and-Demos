package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Employee;
import com.example.services.EmployeeService;

//To mark this class as a controller component we use the Controller annotation
@Controller
//To mark a base uri you can use @RequestMapping
@RequestMapping("/employee")
//There is one last setting that may be useful
@CrossOrigin(origins="*")
public class EmployeeController {
	
	private EmployeeService eService;
	
	@Autowired
	public EmployeeController(EmployeeService eService) {
		this.eService = eService;
	}
	
	//Mapping to create a user
	//We can map a request to an endpoint with a specific type with @RequestMapping
	//@RequestMapping(value="/", method=RequestMethod.GET)
	//Or we can use the specialized annotations
	@PostMapping("/")
	//The response body tag, tells Spring to return an employee object to the client when the request is done
	public @ResponseBody Employee createEmployee(/* RequestBody annotation, says we are expecting a employee */@RequestBody Employee e){
		
		return eService.saveEmployee(e);
	}
	
	@PostMapping("/login")
	public @ResponseBody Employee loginEmployee(@RequestBody LinkedHashMap<String, String> body) {
		
		String username = body.get("username");
		String password = body.get("password");
		
		return eService.login(username, password);
	}
	
	//PathParameters and PathVariables
	//PathVariable will look like this http://url/get/variable
	//PathParameter will look like this http://url/get?var=name
	//Spring allows us to use with different annotations
	@GetMapping("/search/{username}")
	public @ResponseBody ResponseEntity<Object> getUserByUsername(@PathVariable(name="username")String username){
		
		Employee e = eService.getByUsername(username);
		
		if(e == null) {
			return new ResponseEntity<>("The user did not exist", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(e.getTickets(), HttpStatus.OK);
		
	}
	
	@GetMapping("/search")
	public @ResponseBody ResponseEntity<Object> getUserById(@RequestParam(name="id")int id){
		
		Employee e = eService.getById(id);
		
		if(e == null) {
			return new ResponseEntity<>("The user did not exist", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(e, HttpStatus.OK);
		
	}

}
