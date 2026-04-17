package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.EmployeeDTO;
import com.service.EmployeeServiceimpl;

public class EmployeesDAOimpl implements EmployeesDAO {
	@Override
	public void createTable() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql="create table if not exists employeesDT(sn INT AUTO_INCREMENT PRIMARY KEY,"
					+ "ename varchar(30),"
					+ "address varchar(100),"
					+ "age int,"
					+ "salary int)";
			statement.execute(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				statement.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public String addEmployee(EmployeeDTO employeeDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "insert into employeesdt(ename,address,age,salary) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,employeeDTO.getEname());
			ps.setString(2, employeeDTO.getAddress());
			ps.setInt(3, employeeDTO.getAge());
			ps.setDouble(4, employeeDTO.getSalary());
			
			int row = ps.executeUpdate();
			if(row==1) {
				return "SAVE";
			}
			else {
				return "NOT SAVE";
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
			return "FAILED TO SAVED";
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<EmployeeDTO> readEmployee() {
		
		ArrayList<EmployeeDTO> arrlist = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select * from employeesdt";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();	
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO(rs.getString("ename"),rs.getString("address"),rs.getInt("age"),rs.getDouble("salary"));
				arrlist.add(employeeDTO);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			return arrlist;
		}
	}

	
	@Override
	public ArrayList<EmployeeDTO> removeEmployee(int id_no) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "delete from employeesdt where ename=? and address=? and age=? and salary=?";
			ps = conn.prepareStatement(sql);
			
			EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
			ArrayList<EmployeeDTO> employee = employeeServiceimpl.readEmployee();
			
			EmployeeDTO emp = employee.get(id_no-1);
			String ename = emp.getEname();
			String address = emp.getAddress();
			int age = emp.getAge();
			double salary = emp.getSalary();
			
			ps.setString(1, ename);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.setDouble(4, salary);
			
			int row = ps.executeUpdate();
			if(row==1) {
				System.out.println("Deleted");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	static int id;
	@Override
	public ArrayList<EmployeeDTO> updateEmployeeData(int id_no) {
		id = id_no;
		ArrayList<EmployeeDTO> arrlist = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String Read_sql = "select * from employeesdt where ename=? and address=? and age=? and salary=?";
			ps = conn.prepareStatement(Read_sql);
			
			EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
			ArrayList<EmployeeDTO> employee = employeeServiceimpl.readEmployee();
			
			EmployeeDTO emp = employee.get(id_no-1);
			String ename = emp.getEname();
			String address = emp.getAddress();
			int age = emp.getAge();
			double salary = emp.getSalary();
			
			
			ps.setString(1, ename);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.setDouble(4, salary);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO(rs.getString("ename"),rs.getString("address"),rs.getInt("age"),rs.getDouble("salary"));
				arrlist.add(employeeDTO);
			}
		}
		catch(Exception e) {
			
		}
		finally {
			return arrlist;
		}
	}

	@Override
	public ArrayList<EmployeeDTO> setEmployeeUpdates(String ename, String address, int age, double salary) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "update employeesdt set ename=?,address=?,age=?,salary=? where ename=? and address=? and age=? and salary=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,ename);
			ps.setString(2,address);
			ps.setInt(3,age);
			ps.setDouble(4,salary);
			
			EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
			ArrayList<EmployeeDTO> employee = employeeServiceimpl.readEmployee();
			
			EmployeeDTO emp = employee.get(id-1);
			String preename = emp.getEname();
			String preaddress = emp.getAddress();
			int preage = emp.getAge();
			double presalary = emp.getSalary();
			
			ps.setString(5,preename);
			ps.setString(6,preaddress);
			ps.setInt(7,preage);
			ps.setDouble(8,presalary);
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
