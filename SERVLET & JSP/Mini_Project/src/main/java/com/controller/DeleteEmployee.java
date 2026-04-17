package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmployeeDTO;
import com.service.EmployeeServiceimpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
		ArrayList<EmployeeDTO> employee = employeeServiceimpl.readEmployee();
		
		request.setAttribute("data",employee);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deleteEmployee.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_no = Integer.parseInt(request.getParameter("no"));
		EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
		employeeServiceimpl.removeEmployee(id_no);
		
		EmployeeServiceimpl employeeServiceimpl2 = new EmployeeServiceimpl();
		ArrayList<EmployeeDTO> employee = employeeServiceimpl2.readEmployee();
		
		request.setAttribute("data",employee);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deleteEmployee.jsp");
		rd.forward(request, response);
	}

}
