package com.service;

import java.util.ArrayList;

import com.dto.EmployeeDTO;

public interface EmployeeService {
	String addEmployee(EmployeeDTO employeeDTO);
	ArrayList<EmployeeDTO> readEmployee();
	ArrayList<EmployeeDTO> updateEmployee(int id_no);
	ArrayList<EmployeeDTO> setEmployeeUpdates(String ename,String address,int age,double salary);
	ArrayList<EmployeeDTO> removeEmployee(int id_no);
}
