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


@WebServlet("/updateEmployeeData")
public class UpdateEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeServiceimpl employeeServiceImpl = new EmployeeServiceimpl();
		ArrayList<EmployeeDTO> employee = employeeServiceImpl.readEmployee();
		
		request.setAttribute("data", employee);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateEmployeeData.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_no = Integer.parseInt(request.getParameter("no"));
		EmployeeServiceimpl employeeServiceImpl = new EmployeeServiceimpl();
		employeeServiceImpl.updateEmployee(id_no);
		
		ArrayList<EmployeeDTO> employee = employeeServiceImpl.updateEmployee(id_no);
		request.setAttribute("SelectedData", employee);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateDataPanel.jsp");
		rd.forward(request, response);
	}

}
