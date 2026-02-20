package com.JDBCconn;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_management";
	private static final String DB_UNAME = "root";
	private static final String DB_PASSWORD = "Dipesh@9092";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASSWORD);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
