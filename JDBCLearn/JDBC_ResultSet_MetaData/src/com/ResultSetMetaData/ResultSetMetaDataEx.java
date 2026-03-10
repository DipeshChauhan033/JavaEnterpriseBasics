package com.ResultSetMetaData;
import java.sql.*;
public class ResultSetMetaDataEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String username = "root";
			String password = "Dipesh@9092";
			
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from employee";
			
			preparedstatement = conn.prepareStatement(sql);
			resultset = preparedstatement.executeQuery();
			
			ResultSetMetaData metadata = resultset.getMetaData();
			
			//Database Name
			String databasename = metadata.getCatalogName(1);
			System.out.println("Database Name: "+ databasename);
			
			//Table Name
			String tablename = metadata.getTableName(1);
			System.out.println("\nTable Name: "+ tablename);
			
			int TotalColumns = metadata.getColumnCount();
			System.out.println("\nTotalColumns in employee table: "+TotalColumns);
			
			//Columns-Name
			for(int i=1;i<=TotalColumns;i++) {
				String ColumnName = metadata.getColumnName(i);
				System.out.printf("\nColumn%d is : "+ColumnName,i);
				
			}
			
			System.out.println();
			//Columns-Type
			for(int i=1;i<=TotalColumns;i++) {
				String ColumnName = metadata.getColumnClassName(i);
				System.out.printf("\nColumn%d Type is : "+ColumnName,i);
			}
			
			System.out.println();
			//Columns-Size
			for(int i=1;i<=TotalColumns;i++) {
				int ColumnName = metadata.getColumnDisplaySize(i);
				System.out.printf("\nColumn%d Type is : "+ColumnName,i);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultset.close();
				preparedstatement.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

