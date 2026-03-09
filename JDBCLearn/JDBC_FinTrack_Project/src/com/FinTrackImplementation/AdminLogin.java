package com.FinTrackImplementation;
import java.sql.*;
import com.connectivity.*;
import java.util.Scanner;

public class AdminLogin {
	Scanner sc = new Scanner(System.in);
	SqlOperations adminfunctionality = new SqlOperations();
	public AdminLogin() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select aid,password from admin where aid=? and password=?";
			System.out.print("Enter ADMIN ID: ");
			
			int aid = sc.nextInt();
			System.out.println("");
			System.out.print("Enter ADMIN PASSWORD: ");
			String pass = sc.next();
			
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, aid);
			preparedstatement.setString(2, pass);
			
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				int storedaid = resultset.getInt("aid");
				String storedpass = resultset.getString("password");
				
				if(aid==storedaid && pass.equals(storedpass)) {
					System.out.println("");
					System.out.println("Login successful. Welcome back, Admin!\r\nYou now have access to the administration panel.\n");
					System.out.println("===== Admin Panel =====");
					System.out.println("Enter 1 to view all customers");
					System.out.println("Enter 2 to view all accounts");
					System.out.print("Please enter your choice: ");
					int choice = sc.nextInt();
					System.out.println("\n");
					if(choice==1) {
						adminfunctionality.viewAllCustomers();
					}
					else if(choice==2) {
						adminfunctionality.viewAllAccounts();
					}
					else {
						System.out.println("Invalid choice. Please enter a valid option.");
					}
					
				}
				else {
					System.out.println("Authentication failed. The Admin ID or Password you entered is incorrect.");
				}
			}
			else {
				System.out.println("Authentication failed. The Admin ID or Password you entered is incorrect.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
