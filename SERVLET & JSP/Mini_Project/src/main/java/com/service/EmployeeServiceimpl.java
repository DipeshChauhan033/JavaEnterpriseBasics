package com.service;

import java.util.ArrayList;

import com.dao.EmployeesDAOimpl;
import com.dto.EmployeeDTO;

public class EmployeeServiceimpl implements EmployeeService {
	public String addEmployee(EmployeeDTO employeeDTO) {
		
		//Data Processing like validation
		EmployeesDAOimpl employeeDAOimpl = new EmployeesDAOimpl();
		return employeeDAOimpl.addEmployee(employeeDTO);
	}

	@Override
	public ArrayList<EmployeeDTO> readEmployee() {
		EmployeesDAOimpl employeeDAOimpl = new EmployeesDAOimpl();
		return employeeDAOimpl.readEmployee();
	}

	@Override
	public ArrayList<EmployeeDTO> updateEmployee(int id_no) {
		EmployeesDAOimpl employeeDAOimpl = new EmployeesDAOimpl();
		return employeeDAOimpl.updateEmployeeData(id_no);
	}
	
	@Override
	public ArrayList<EmployeeDTO> removeEmployee(int id_no) {
		EmployeesDAOimpl employeeDAOimpl = new EmployeesDAOimpl();
		return employeeDAOimpl.removeEmployee(id_no);
	}

	@Override
	public ArrayList<EmployeeDTO> setEmployeeUpdates(String ename, String address, int age, double salary) {
		EmployeesDAOimpl employeeDAOimpl = new EmployeesDAOimpl();
		return employeeDAOimpl.setEmployeeUpdates(ename, address, age, salary);
	}

	
}
 