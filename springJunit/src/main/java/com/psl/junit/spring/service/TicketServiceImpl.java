package com.psl.junit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.junit.spring.dao.TicketDao;
import com.psl.junit.spring.dto.Ticket;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao dao;
	public int buyTicket(String passengerName, String phone) {
		
		Ticket ticket = new Ticket();
		
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return getDao().createTicket(ticket);
		
	}
	public TicketDao getDao() {
		return dao;
	}
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

}
