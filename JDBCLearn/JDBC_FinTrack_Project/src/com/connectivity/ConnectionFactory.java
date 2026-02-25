package com.connectivity;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String url = "jdbc:mysql://localhost:3306/fintrack";
	private static final String uname = "root";
	private static final String password = "Dipesh@9092";
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,uname,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void close(AutoCloseable StateAndConn) {
		try {
			if(StateAndConn!=null) {
				StateAndConn.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

