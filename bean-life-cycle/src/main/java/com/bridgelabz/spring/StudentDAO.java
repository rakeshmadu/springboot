package com.bridgelabz.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	private String USER_NAME = "root";
	private String PASSWORD = "";
	
	public void selectAllRows() throws ClassNotFoundException, SQLException
	{
		//load driver
		Class.forName(driver);
		
		//get a connection
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		
		//EXECUTEquery
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee_payroll;");
	}
}
