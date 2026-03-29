package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Config..
		ServletConfig servletconfig = getServletConfig();
		String value1 = servletconfig.getInitParameter("url");
		System.out.println(value1);
		
		
		//Context..
		ServletContext servletcontext = getServletContext();
		String value2 = servletcontext.getInitParameter("Key");
		System.out.println(value2);
		
		//Set Attribute	and use in servlet2 -Dyanamic
		servletcontext.setAttribute("username","Username: root");
		
		response.sendRedirect("index.html");
	}

}
