package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		System.out.printf("VALIDATE NAME: %s & ADDRESS: %s",name,address);
		System.out.println();
		
		response.getWriter().println("Data Validate");
		
		RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		//rd.forward(request, response);
		
		rd.include(request, response); //Response both servlet response
		
	}

}
