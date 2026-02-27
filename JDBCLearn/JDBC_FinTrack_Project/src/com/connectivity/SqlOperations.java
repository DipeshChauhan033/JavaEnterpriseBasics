package com.connectivity;
import java.util.Scanner;
import com.FinTrackImplementation.CustomerLogin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlOperations {
	Scanner sc = new Scanner(System.in);
	CustomerLogin clogin = new CustomerLogin();
	public SqlOperations() {
		createTable();
	}
	
	public void createTable() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "create table if not exists customers(sn INT AUTO_INCREMENT UNIQUE KEY,"
					+ "cid int PRIMARY KEY,"
					+ "cname varchar(100)NOT NULL,"
					+ "password varchar(30)NOT NULL,"
					+ "mobile_no varchar(10)NOT NULL UNIQUE,"
					+ "address varchar(100)NOT NULL,"
					+ "CHECK (mobile_no REGEXP '^[0-9]{10}$')"
					+ ")";
			
			statement.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void customer_registration() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "insert into customers(cid,cname,password,mobile_no,address) values(?,?,?,?,?)";
			preparedstatement = conn.prepareStatement(sql);
			
			System.out.print("Enter customer id: ");
			int cid = sc.nextInt();
			preparedstatement.setInt(1,cid);
			
			System.out.print("Enter customer name: ");
			String cname = sc.next();
			preparedstatement.setString(2, cname);
			
			System.out.print("Enter psaaword: ");
			String password = sc.next();
			preparedstatement.setString(3, password);
			
			System.out.print("Enter mobile no: ");
			String mobile_no = sc.next();
			sc.nextLine();
			preparedstatement.setString(4,mobile_no);
			
			System.out.print("Enter permanent address: ");
			String address = sc.nextLine();
			preparedstatement.setString(5,address);
			System.out.println("");
			
			int check = preparedstatement.executeUpdate();
			
			if(check>0) {
				System.out.println("\nAccount Created Successfully!");
				System.out.println("Thank you for registering with us.");
				System.out.println("You can now login using your Customer ID and Password.");
				System.out.println("--------------------------------------------");
				
				clogin.customerLogin();
			}
		}
		catch(Exception e) {
			System.out.println("--- please enter valid mobile number");
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void viewCustomerDetails() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "select * from customers where cid=? and password=?";
			preparedstatement = conn.prepareStatement(sql);
			
			int cid = clogin.cid;
			preparedstatement.setInt(1, cid);
			String pass = clogin.pass;
			preparedstatement.setString(2,pass);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				int sn = resultset.getInt("sn");
				int customerid = resultset.getInt("cid");
				String cname = resultset.getString("cname");
				String password = resultset.getString("password");
				String mobile_no = resultset.getString("mobile_no");
				String address = resultset.getString("address");
				
				System.out.printf("SN: "+sn +"\nCUSTOMER ID: "+customerid+"\nCUSTOMER NAME: "+cname+"\nPASSWORD: "+password+"\nMOBILE NO: "+mobile_no+"\nADDRESS: "+address);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
