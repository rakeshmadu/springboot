package com.bridgelabz.spring;
import java.sql.Connection;

import com.bridgelabz.spring.StudentDAO;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDAO dao = new StudentDAO();
		dao.selectAllRows();
		
	}

}
