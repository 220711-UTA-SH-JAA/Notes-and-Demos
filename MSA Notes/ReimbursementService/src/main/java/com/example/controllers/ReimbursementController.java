package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.models.Reimbursement;
import com.example.service.ReimbursementService;

@RestController
@CrossOrigin
@RequestMapping("/reimbursement")
public class ReimbursementController {
	
	private ReimbursementService rServ;
	
	@Autowired
	public ReimbursementController(ReimbursementService rServ) {
		this.rServ = rServ;
	}
	
	@PostMapping("/create")
	public Reimbursement create(@RequestBody Reimbursement r) {
		return rServ.createReimbursement(r);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody LinkedHashMap<String, String> body) {
		String url = "http://localhost:8001/employee/manager";
		
		RestTemplate rest = new RestTemplate();
		
		ManagerCheck mc = new ManagerCheck();
		mc.id = body.get("managerId");
		
		HttpEntity<ManagerCheck> request = new HttpEntity<ManagerCheck>(mc);
		
		Boolean manager = rest.postForObject(url, request, Boolean.class);
		
		if(manager == false) {
			return new ResponseEntity("Must be a manager to approve or deny requests", HttpStatus.UNAUTHORIZED);
		}
		
		Reimbursement r = rServ.approveOrDenyTicket(Integer.parseInt(body.get("ticketId")), Boolean.parseBoolean(body.get("approved")), Integer.parseInt(body.get("managerId")));
		
		return new ResponseEntity(r, HttpStatus.OK);
	}

}

class ManagerCheck {
	public String id;
}
