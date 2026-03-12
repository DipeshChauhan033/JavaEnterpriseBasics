package com.connectionPooling;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



public class ConnectionPooling {

	public static void main(String[] args) {
		HikariDataSource hikaridatasource = null;
		
		try {
			Properties properties = new Properties();
			FileInputStream file = new FileInputStream("config.properties");
			properties.load(file);
			
			//CONNECTION DETAILS--->HIKARI
			String url = (String) properties.get("mysql.url");
			String uname = (String) properties.get("mysql.username");
			String pass = (String) properties.get("mysql.password");
			
			HikariConfig hikariconfig = new HikariConfig();
			hikariconfig.setJdbcUrl(url);
			hikariconfig.setUsername(uname);
			hikariconfig.setPassword(pass);
			
			hikaridatasource = new HikariDataSource(hikariconfig); //pool ready
			Connection conn = hikaridatasource.getConnection();//Get from the pool
			System.out.println(conn);
			
			conn.close();//Back to pool
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			hikaridatasource.close();//Closing (COMPLETE POOL)
		}

	}

}
