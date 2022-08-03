package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static ConnectionUtil connectionUtil = null;
	
	private ConnectionUtil() {}
	
	public static ConnectionUtil getInstance() {
		if(connectionUtil == null) {
			connectionUtil = new ConnectionUtil();
		}
		
		return connectionUtil;
	}
	
	public Connection getConnection(String dbName) {
		String url = System.getenv("DB_URL");
		url = url + "/" + dbName;
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		Connection con = null;
		
		try {
			//This is just hardcoding the dbname, we could include this in the environment variable,
			//Or we could pass this as a paremeter to our connection method
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
