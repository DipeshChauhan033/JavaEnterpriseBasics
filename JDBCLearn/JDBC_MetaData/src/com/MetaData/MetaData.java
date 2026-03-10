package com.MetaData;
import java.sql.*;
public class MetaData {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String username = "root";
			String password = "Dipesh@9092";
			
			conn = DriverManager.getConnection(url,username,password);
			
			DatabaseMetaData metadata = conn.getMetaData();
			
			String url1 = metadata.getURL();
			System.out.println("Dynamically--: \n\n"+url1);
			
			String uname = metadata.getUserName();
			System.out.println(uname);
			
			System.out.println("===== Metadata of Database =====");
			String DatabaseProductName = metadata.getDatabaseProductName();
			String DatabaseProductVersion = metadata.getDatabaseProductVersion();
			int DatabaseMinorVersion = metadata.getDatabaseMinorVersion();
			int DatabaseMajorVersion = metadata.getDatabaseMajorVersion();
			
			System.out.println("DatabaseProductName: "+DatabaseProductName);			
			System.out.println("DatabaseProductVersion: "+DatabaseProductVersion);
			System.out.println("DatabseMinorVersion: "+DatabaseMinorVersion);
			System.out.println("DatabseMajorVersion: "+DatabaseMajorVersion);
			 
			System.out.println("");
			System.out.println("===== MetaDta of Driver =====");
			String DriverName = metadata.getDriverName();
			String DriverVersion = metadata.getDriverVersion();
			int DrivereMinorVersion = metadata.getDriverMinorVersion();
			int DriverMajorVersion = metadata.getDriverMajorVersion();
			
			System.out.println("DriverName: "+DriverName);			
			System.out.println("DriverVersion: "+DriverVersion);
			System.out.println("DrivereMinorVersion: "+DrivereMinorVersion);
			System.out.println("DriverMajorVersion: "+DriverMajorVersion);
			System.out.println("\n");
			
			int MaxUserNameLength = metadata.getMaxUserNameLength();
			System.out.println("MaxUserNameLength: "+MaxUserNameLength);
			
			int MaxColumnsInTable = metadata.getMaxColumnsInTable();
			int MaxRowsInTable = metadata.getMaxRowSize();
			
			System.out.println("MaxColumnsInTable: "+MaxColumnsInTable);
			System.out.println("MaxRowsInTable: "+MaxRowsInTable);
			
		
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
