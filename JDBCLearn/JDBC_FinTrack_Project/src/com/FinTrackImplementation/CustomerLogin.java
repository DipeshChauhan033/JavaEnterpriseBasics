package com.FinTrackImplementation;
import java.sql.*;
import java.util.Scanner;
import com.connectivity.*;


public class CustomerLogin {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement preparedstatement = null;
	public static int cid;
	public static String pass;
	
	public void customerLogin() {
		System.out.println("\n===== Customer Login =====");
		System.out.println("Please enter your credentials to continue.");
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select cid,password from customers where cid=? and password=?";
			preparedstatement = conn.prepareStatement(sql);
			
			System.out.print("Enter Customer ID: ");
			cid = sc.nextInt();
			System.out.println();
			System.out.print("Enter Password: ");
			pass = sc.next();
			System.out.println("");
			
			preparedstatement.setInt(1,cid);
			preparedstatement.setString(2, pass);
			
			ResultSet result = preparedstatement.executeQuery();			
			if(result.next()) {
				int getcid = result.getInt("cid");
				String getpass = result.getString("password");
				
				if((getcid==cid) && (getpass.equals(pass))) {
					System.out.println("Authentication completed successfully..\nWelcome to your dashboard.");
					CustomerFunctionality viewcustomerdetails = new CustomerFunctionality();				}
			}
			else{
				System.out.println("USER NOT FOUND");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
		
	}
}
