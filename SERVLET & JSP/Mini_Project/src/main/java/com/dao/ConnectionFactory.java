package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private static HikariDataSource hikaridatasource;
	
	public static void init(String url,String username,String password,String driver) {
		try {
			Class.forName(driver);
			HikariConfig hikariconfig = new HikariConfig();
			
			hikariconfig.setJdbcUrl(url);
			hikariconfig.setUsername(username);
			hikariconfig.setPassword(password);
			
			
			hikariconfig.setMaximumPoolSize(20);
			hikariconfig.setMinimumIdle(5);
			hikariconfig.setIdleTimeout(300000);
			hikariconfig.setConnectionTimeout(30000);
			
			hikaridatasource = new HikariDataSource(hikariconfig);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return hikaridatasource.getConnection();
		
	}
}
