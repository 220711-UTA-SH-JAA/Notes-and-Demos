package com.example.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TicketDao;
import com.example.models.Employee;
import com.example.models.Ticket;

@Service("TicketServiceBean")
public class TicketService {
	
	//Once again, not creating an instance of the tDao, this will injected via the beans.xml when it creates the bean
	private TicketDao tDao;
	
	public TicketService() {
		
	}
	
	@Autowired
	public void setTDao(TicketDao tDao) {
		this.tDao = tDao;
	}
	
	public void printNewTicket(int id) {
		System.out.println(tDao.selectTicketById(id));
	}

	public void createTicket(String desc, Double amount, String type, Employee submitter) {

		LocalDateTime submittedDate = LocalDateTime.now();
		List<Employee> resolvers = new ArrayList<>();
		
		Ticket t = new Ticket(0, desc, amount, type, "PENDING", submitter, submittedDate, resolvers, null);
		
		tDao.createTicket(t);
	}

}
