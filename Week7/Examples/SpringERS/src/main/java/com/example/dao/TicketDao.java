package com.example.dao;

import com.example.models.Ticket;

public interface TicketDao {

	Ticket selectTicketById(int id);
	
}
