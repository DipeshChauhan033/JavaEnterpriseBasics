package com.AtomictyExample;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Launch {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		Scanner sc = new Scanner(System.in);
		try {
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String username = "root";
			String password = "Dipesh@9092";
			
			conn = DriverManager.getConnection(url,username,password);
			conn.setAutoCommit(false);
			
			String sql = "update employee set salary=? where username=?";
			
			preparedstatement = conn.prepareStatement(sql);
			
			
			System.out.print("Enter the username of the employee whose salary you want to update: ");
			String uname1 = sc.next();
			System.out.println("");
			System.out.print("Enter the new salary to update: ");
			int salary1 = sc.nextInt();

			preparedstatement.setInt(1,salary1);
			preparedstatement.setString(2, uname1);
			
			preparedstatement.executeUpdate();
			
			
			System.out.print("Enter the username of the employee whose salary you want to update: ");
			String uname2 = sc.next();
			System.out.println("");
			System.out.print("Enter the new salary to update: ");
			int salary2 = sc.nextInt();

			preparedstatement.setInt(1,salary2);
			preparedstatement.setString(2, uname2);
			
			preparedstatement.executeUpdate();
			
			
			System.out.print("Enter the username of the employee whose salary you want to update: ");
			String uname3 = sc.next();
			System.out.println("");
			System.out.print("Enter the new salary to update: ");
			int salary3 = sc.nextInt();

			preparedstatement.setInt(1,salary3);
			preparedstatement.setString(2, uname3);
			
			preparedstatement.executeUpdate();
			
			conn.commit();
			
		}
		catch(Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				preparedstatement.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
