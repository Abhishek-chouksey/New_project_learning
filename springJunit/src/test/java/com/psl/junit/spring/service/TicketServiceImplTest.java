package com.psl.junit.spring.service;


import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psl.junit.spring.dao.TicketDao;
import com.psl.junit.spring.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "/application-context.xml")
public class TicketServiceImplTest {
	
	private static final int Result = 1;
	private static final String phone = "1234567789";
	private static final String passengerName="Abhi";
	
	@Mock
	TicketDao dao;
	
	@Autowired
	@InjectMocks
	private TicketServiceImpl service;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicket() {
	
		Mockito.when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(passengerName, phone);
		assertEquals(result, Result);
	
	}

}
