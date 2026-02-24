package com.BatchProcessingConcept;
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
			
			String sql = "insert into employee(username,password,fullname,address,salary) values(?,?,?,?,?)";
			preparedstatement = conn.prepareStatement(sql);
			
			while(true) {
				System.out.println("Enter username: ");
				String uname = sc.next();
				preparedstatement.setString(1, uname);
				
				System.out.println("ENter password: ");
				String pass = sc.next();
				preparedstatement.setString(2, pass);
				
				System.out.println("Enter fullname: ");
				String fname = sc.nextLine();
				preparedstatement.setString(3, fname);
				sc.nextLine();
				
				System.out.println("Enter address: ");
				String address = sc.nextLine();
				preparedstatement.setString(4, address);
	
				
				System.out.println("Enter salary: ");
				double salary = sc.nextDouble();
				preparedstatement.setDouble(5, salary);
				
				
				preparedstatement.addBatch();
				
				System.out.print("Do you want to INSERT MORE:(Y)");
				String choice = sc.next().toUpperCase().trim();
				
				if(!choice.equals("Y")) {
					int[] i = preparedstatement.executeBatch();
					System.out.println("ROW INSERTED: "+i.length);
					conn.commit();
					break;
				}
				
			}
			
			
			
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
