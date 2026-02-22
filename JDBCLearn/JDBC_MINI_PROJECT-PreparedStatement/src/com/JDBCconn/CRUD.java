package com.JDBCconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.employee.dto.EmployeeDTO;
import java.util.Scanner;
public class CRUD {
	
	public CRUD() {
		//Table Creation..
		createTable();
	}
	
	public void createTable() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS employee(sn INT AUTO_INCREMENT PRIMARY KEY,"
					+ "USERNAME varchar(30)NOT NULL UNIQUE,"
					+ "PASSWORD varchar(30),"
					+ "FULLNAME varchar(100),"
					+ "ADDRESS varchar(200),"
					+ "salary int);"; 
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void insert(EmployeeDTO employeeDTO) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "insert into employee(username,password,fullname,address,salary) values(?,?,?,?,?)";
			preparedstatement = conn.prepareStatement(sql);
			
			
			preparedstatement.setString(1,employeeDTO.getUname());
			preparedstatement.setString(2,employeeDTO.getPassword());
			preparedstatement.setString(3,employeeDTO.getFullname());
			preparedstatement.setString(4,employeeDTO.getAddress());
			preparedstatement.setDouble(5,employeeDTO.getSalary());
			
			preparedstatement.executeUpdate();
			
			System.out.println("Data Inserted");

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	public void read(String username,String password) {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "select * from employee where username=? and password=?";
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1,username);
			preparedstatement.setString(2,password);
			resultset = preparedstatement.executeQuery(); 
			System.out.println("======Data Loaded=========");
			
			//For select all data--select * from employee;(not specific column using where..)
			/*while(resultset.next()) {
				int sn = resultset.getInt("sn");
				String uname = resultset.getString("username");
				String password = resultset.getString("password");
				String fullname = resultset.getString("fullname");
				String address = resultset.getString("address");
				double salary = resultset.getDouble("salary");
				
				System.out.println(sn+" "+uname+" "+password+" "+fullname+" "+address+" "+salary);
			}*/
			
			if(resultset.next()) {
				int sn = resultset.getInt("sn");
				String uname = resultset.getString("username");
				String password2 = resultset.getString("password");
				String fullname = resultset.getString("fullname");
				String address = resultset.getString("address");
				double salary = resultset.getDouble("salary");
				
				System.out.println(sn+" "+uname+" "+password2+" "+fullname+" "+address+" "+salary);
			}
			else {
				System.out.println("Data not found");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
		
	}
	public void update(String username,double salary) {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "update employee set salary='?' where username='?'";
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setDouble(1, salary);
			preparedstatement.setString(2, username);
			int executeUpdate = preparedstatement.executeUpdate();
			
			
			if(executeUpdate>0) {
				System.out.println("Data Updated..");
			}
			else {
				System.out.println("Username not founds");
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
	public void delete(String username) {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "delete from employee where username='?";
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			int executeUpdate = preparedstatement.executeUpdate();
			
			if(executeUpdate>0) {
				System.out.println("Data Deleted...");
			}
			else {
				System.out.println("Username not founds");
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
