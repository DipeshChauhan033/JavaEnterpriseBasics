package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;
import com.service.EmployeeServiceimpl;


@WebServlet(urlPatterns={"/viewAddEmployee","/addEmployee"})
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		
		EmployeeDTO empDTO = new EmployeeDTO(ename,address,Integer.parseInt(age),Double.parseDouble(salary));
		
		EmployeeService employeeService = new EmployeeServiceimpl();
		String result = employeeService.addEmployee(empDTO);
		
		request.setAttribute("msg",result);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp");
		rd.forward(request, response);
	}

}
