package com.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Launch {

	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver"); //Optional
			String url = "jdbc:mysql://localhost:3309";
			String username = "root";
			String password="";
			
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
