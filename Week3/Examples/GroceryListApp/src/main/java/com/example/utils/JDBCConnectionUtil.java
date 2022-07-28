package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class to create a connection to our database
 */
public class JDBCConnectionUtil {
	/*
	 * Setting up our Database Driver/Connection
	 * 
	 * To establish our database connection, we will need what is known as the driver
	 * - These are database specific (we will specificaly need the postgres driver)
	 * - You can get through Maven Dependencies
	 * 
	 * <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
		<dependency>
    	<groupId>org.postgresql</groupId>
    	<artifactId>postgresql</artifactId>
    	<version>42.4.0</version>
	  </dependency>

	 *
	 *	Establishing our Connection
	 *	
	 *	To create a connection you need to use the DriverManager.getConnection() Method
	 *	- Driver manager will come from java.sql.DriverManager
	 *	We must pass in 3 parameters for the DriverManager to make this connection
	 *	- URL to the database (jdbc:postgresql://host:5432/databasename)
	 *	- username
	 *	- password
	 *
	 *	After we make the connection, we can use that connection to make statements which execute queries
	 *
	 *	Parameterization Via Properties Files or Environment Variables
	 *	
	 *	We want to use a properties file that is gitignored, or environment variables on our computer to hide the
	 *	database connection information 
	 *
	 *	This is to keep our database server safe from people browsing github looking for credentials
	 */
	
	//Doing this because we are using the singleton design pattern
	private static JDBCConnectionUtil util;

	private static Properties props = new Properties();
	
	//The constructor is private, because we want to restrict who/how it is called so that we only ever have
	//one instance of our connection utility code
	private JDBCConnectionUtil() {}
	
	public static JDBCConnectionUtil getInstance() {
		if(util == null) {
			return new JDBCConnectionUtil();
		}
		return util;
	}
	
	/* First is through our properties file, remember to gitignore it
	 * 
	 * To gitignore it, you first need a gitignore, these are just stored in files called .gitignore
	 * Add a line to the .gitignore which says this **	/resources/*.properties
	 * 
	 */
	
	//If you are using this method, you can just call this getConnection()
	public Connection getConnectionThroughPropFile() {
		//This will look in our src/main/resources for a jdbc.properties file and load it in for us as a byte stream
		
		Connection con = null;
		
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			
			String url="";
			String password="";
			String username="";
			
			props.load(in);
			
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
			//After we load our url, username, and password from the file, we want to attempt making a connection
			con = DriverManager.getConnection(url, username, password);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Connection getConnectionThroughENV() {
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		Connection con = null;
		
		try {
			//This is just hardcoding the dbname, we could include this in the environment variable,
			//Or we could pass this as a paremeter to our connection method
			url = url + "/grocerydb";
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Connection getConnectionThroughENV(String dbName) {
		String url = System.getenv("DB_URL");
		url = url + "/" + dbName;
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		Connection con = null;
		
		try {
			//This is just hardcoding the dbname, we could include this in the environment variable,
			//Or we could pass this as a paremeter to our connection method
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
