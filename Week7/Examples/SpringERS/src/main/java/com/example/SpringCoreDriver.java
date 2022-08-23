package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.*;
import com.example.models.Employee;
import com.example.models.Ticket;
import com.example.services.EmployeeService;
import com.example.services.TicketService;

public class SpringCoreDriver {
	
	//Before, we would have to do one of these numbers
	//Because of spring, all we have to do is get the instance of the EmployeeService from the beans.xml/our application
	//context
	/*
	private static EmployeeDao eDao = new EmployeeDaoMock();
	private static EmployeeService eService = new EmployeeService(eDao);
	*/
	private static EmployeeService eService;
	
	private static TicketService tService;
	
	private static EmployeeDao eDao;
	
	private static TicketDao tDao;
	
	public static void main(String args[]) {
		
		//Create an instance of our IOC container, aka the ApplicationContext
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//Set the eService
		eService = appContext.getBean("EmployeeServiceBean", EmployeeService.class);
		
		tService = appContext.getBean("TicketServiceBean", TicketService.class);
		
		eDao = appContext.getBean("EmployeeDaoBean", EmployeeDaoImpl.class);
		
		tDao = appContext.getBean("TicketDaoBean", TicketDaoImpl.class);
		
		Employee ethan = new Employee(0, "Ethan", "McGill", "emcgill", "password", true, new HashSet<>());
		
		eDao.createEmployee(ethan);
		
		//In normal java, this line would cause a NullPointerException
		eService.printAllEmployees();
		
		ethan = eDao.selectAllEmployees().get(0);
		
		Ticket t = new Ticket(0, "Money plz", 100.00, "TRAVEL", "PENDING", ethan, LocalDateTime.of(2022, 8, 23, 11, 0), new ArrayList<>(), null);
		
		tDao.createTicket(t);
		
		tService.printNewTicket(2);
		
		eService.printAllEmployees();
		
	}

}
