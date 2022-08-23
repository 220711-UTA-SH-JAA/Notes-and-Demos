package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Ticket;

@Transactional
@Repository("TicketDaoBean")
public class TicketDaoImpl implements TicketDao{
	
	private SessionFactory sessFact;
	
	@Autowired
	public TicketDaoImpl(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}

	@Override
	public Ticket selectTicketById(int id) {
		
		List<Ticket> ticket = sessFact.getCurrentSession().createQuery("from Ticket where ticketId=:id", Ticket.class)
				.setParameter("id", id)
				.list();
		
		if(ticket.size() < 1) {
			return null;
		}
		
		return ticket.get(0);
	}

	@Override
	public void createTicket(Ticket t) {
		// TODO Auto-generated method stub
		sessFact.getCurrentSession().save(t);
	}

	@Override
	public void updateTicket(Ticket t) {
		// TODO Auto-generated method stub
		sessFact.getCurrentSession().update(t);
	}

	@Override
	public void deleteTicket(Ticket t) {
		// TODO Auto-generated method stub
		sessFact.getCurrentSession().delete(t);
	}

}
