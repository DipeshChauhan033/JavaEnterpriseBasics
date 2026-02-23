package com.connectionEstablish;
import java.sql.*;

public class Launch {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement callablestatement = null;
		try {
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String uname = "root";
			String password = "Dipesh@9092";
			
			conn = DriverManager.getConnection(url,uname,password);
			
			callablestatement  = conn.prepareCall("{call callablestatement(?,?)}");
			
			callablestatement.setString(1, "m%");
			callablestatement.setInt(2,15000);
			
			ResultSet rs = callablestatement.executeQuery();
			while(rs.next()) {
				System.out.println("Name: "+rs.getString("fullname"));
				System.out.println("Salary: "+rs.getInt("salary"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				callablestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
