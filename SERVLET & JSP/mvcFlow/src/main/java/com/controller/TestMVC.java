package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = "Hello Dipesh..";
		HttpSession session = request.getSession();
		session.setAttribute("message", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/realAll.jsp");
		rd.forward(request, response);
	}

}
