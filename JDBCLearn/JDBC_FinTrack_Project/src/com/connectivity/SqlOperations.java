package com.connectivity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlOperations {
	public SqlOperations() {
		createTable();
	}
	
	public void createTable() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "create table if not exists customers(sn INT AUTO_INCREMENT UNIQUE KEY,"
					+ "cid int PRIMARY KEY,"
					+ "cname varchar(100)NOT NULL,"
					+ "password varchar(30)NOT NULL,"
					+ "mobile_no varchar(10)NOT NULL UNIQUE,"
					+ "address varchar(100)NOT NULL,"
					+ "CHECK (mobile_no REGEXP '^[0-9]{10}$')"
					+ ")";
			
			statement.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
}
