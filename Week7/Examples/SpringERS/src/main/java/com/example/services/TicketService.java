package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TicketDao;

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
	
	public void printNewTicket() {
		System.out.println(tDao.selectTicketById(1));
	}

}
