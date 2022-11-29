package com.bridgelabz.spring;


import java.sql.Connection;

public class App {

	public static void main(String[] args) {
		Config config = Config.getInstance();
		
		Connection connection = config.getConnection();
		
		if(connection != null) 
			System.out.println(" Connection established");
		else
			System.out.println(" Connection failed");
	}
}