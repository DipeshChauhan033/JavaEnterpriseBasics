package com.mainapp;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Launch {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			
			Properties properties = new Properties();
			while(true) {
				
				FileInputStream file = new FileInputStream("config.properties");
				properties.load(file);
				
				String url = (String) properties.get("mysql.url");
				String uname = (String) properties.get("mysql.uname");
				String password = (String) properties.get("mysql.password");
				
				conn = DriverManager.getConnection(url,uname,password);
				System.out.println(conn+" Connection -> "+conn.getCatalog());
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
