package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpTest extends HttpServlet {

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username: "+username+"\n"+"Password: "+password);
		PrintWriter write = response.getWriter();
		write.print("<h1>Sign-up Done...</h1>");
	} 

}
