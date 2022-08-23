package com.example.dao;

import com.example.models.Ticket;

public interface TicketDao {

	Ticket selectTicketById(int id);
	void createTicket(Ticket t);
	void updateTicket(Ticket t);
	void deleteTicket(Ticket t);
	
}
