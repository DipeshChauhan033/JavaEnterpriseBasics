package com.JDBCconn;
import java.sql.Connection;

public class CRUD {
	
	public CRUD() {
		//Table Creation..
		
	}
	public void insert() {
		Connection conn = ConnectionFactory.getConnection();
		System.out.println(conn);
	}
	public void read() {
		
	}
	public void update() {
	
	}
	public void delete() {
	
	}
}
