package com.JDBCconn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.employee.dto.EmployeeDTO;
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
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "insert into employee(username,password,fullname,address,salary)"
					+ "values('"+employeeDTO.getUname()+"','"+employeeDTO.getPassword()+"','"+employeeDTO.getFullname()+"','"+employeeDTO.getAddress()+"',"+employeeDTO.getSalary()+")";
			
			statement.executeUpdate(sql);
			System.out.println("Data Inserted");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	public void read(String username,String password) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "select * from employee where username='"+username+"' and password='"+password+"'";
			resultset = statement.executeQuery(sql); //No Data
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
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		
	}
	public void update(String username,double salary) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "update employee set salary='"+salary+"' where username='"+username+"'";
			int executeUpdate = statement.executeUpdate(sql);
			
			
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
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	public void delete(String username) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "delete from employee where username='"+username+"'";
			int executeUpdate = statement.executeUpdate(sql);
			
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
	}
}
