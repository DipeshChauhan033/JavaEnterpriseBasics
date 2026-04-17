package com.dao;

import java.util.ArrayList;

import com.dto.EmployeeDTO;

public interface EmployeesDAO {
	void createTable();
	String addEmployee(EmployeeDTO employeeDTO);
	ArrayList<EmployeeDTO> readEmployee();
	ArrayList<EmployeeDTO> updateEmployeeData(int id_no);
	ArrayList<EmployeeDTO> setEmployeeUpdates(String ename,String address,int age,double salary);
	ArrayList<EmployeeDTO> removeEmployee(int id_no);
}
