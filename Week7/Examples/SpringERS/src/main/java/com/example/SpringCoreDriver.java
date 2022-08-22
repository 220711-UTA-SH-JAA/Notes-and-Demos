package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.*;
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
	
	public static void main(String args[]) {
		
		//Create an instance of our IOC container, aka the ApplicationContext
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//Set the eService
		eService = appContext.getBean("EmployeeServiceBean", EmployeeService.class);
		
		//In normal java, this line would cause a NullPointerException
		eService.printAllEmployees();
		
		tService = appContext.getBean("TicketServiceBean", TicketService.class);
		
		tService.printNewTicket();
		
	}

}
