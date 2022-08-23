package com.example.dao;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.example.models.Employee;
import com.example.models.Ticket;

public class TicketDaoMock implements TicketDao{

	@Override
	public Ticket selectTicketById(int id) {
		return new Ticket(1, "Send money plz", 1_000_000_000.0, "TRAVEL", "PENDING", new Employee(), LocalDateTime.of(2022, 8, 22, 15, 40), null, null);
	}

	@Override
	public void createTicket(Ticket t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTicket(Ticket t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket(Ticket t) {
		// TODO Auto-generated method stub
		
	}

}
