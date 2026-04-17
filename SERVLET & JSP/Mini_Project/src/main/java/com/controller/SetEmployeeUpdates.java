package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmployeeServiceimpl;


@WebServlet("/setEmployeeUpdates")
public class SetEmployeeUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newename = request.getParameter("ename");
		String newaddress = request.getParameter("address");
		int newage = Integer.parseInt(request.getParameter("age"));
		double newsalary = Double.parseDouble(request.getParameter("salary"));
		int no = Integer.parseInt(request.getParameter("id"));
		
		EmployeeServiceimpl employeeServiceimpl = new EmployeeServiceimpl();
		employeeServiceimpl.setEmployeeUpdates(newename, newaddress, newage, newsalary);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}

}
