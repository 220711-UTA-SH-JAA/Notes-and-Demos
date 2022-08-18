package com.example.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/*
	 * The Session object will be created by the SessionFactory (which we will get from the Configuration)
	 * Session Object wraps the JDBC connection and serves as a factory of Transactions, Queries and Criteria Objects
	 * - Session objects are not threadsafe
	 * - Lightwieght, and hold mandatory first level cache
	 * - Perform crud operations with the methods
	 * 		- .save(), .persist(), .saveOrUpdate()
	 * 		- .get(), .load()
	 * 		- .update(), .merge()
	 * 		- .delete()
	 */
	
	private static SessionFactory sf = null;
	private static Session ses = null;
	
	
	public static Session getSession() {
		
		if(sf == null) {
				/*
				//Configuration class
				Configuration cfg = new Configuration();
				//Load in the properties from the xml file
				cfg.configure("hibernate.cfg.xml");
				
				//Set the environment variable settings
				/*
				cfg.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
				cfg.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
				cfg.setProperty("hibernate.connection.url", (System.getenv("DB_URL") + "/hibernatebank"));
				
				//Build the session factory
				SessionFactory sf = cfg.buildSessionFactory();
				ses = sf.openSession();
				*/
			
			try {
				Class.forName("org.postgresql.Driver");
				sf =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				ses = sf.openSession();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return ses;
		
	}
	
	public static void closeSession() {
		ses.close();
	}

}
