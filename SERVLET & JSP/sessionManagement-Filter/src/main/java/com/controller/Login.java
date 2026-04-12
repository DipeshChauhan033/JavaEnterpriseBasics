package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String data = (String)session.getAttribute("data");
		
		if(data!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uname = request.getParameter("username");
		 String pass = request.getParameter("password");
		 
		 if(uname.equals("MandeepSondagar") && pass.equals("Mandeep123")) {
			 HttpSession session = request.getSession();
			 session.setAttribute("data", uname);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			 rd.forward(request, response);
		 }
	}

}
