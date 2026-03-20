package com.servletlifecycle;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycle extends HttpServlet {
	
	static {
		System.out.println("SERVLET LOADING");
	}
	
    public LifeCycle() {
    	System.out.println("SERVLET INSTANTIATION");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("RESOURCE ALLOCATION");
	}

	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SERVICE");
		
		 PrintWriter out = response.getWriter();
		 out.print("Hello from GET method");
	}

	public void destroy() {
		System.out.println("RESOURCE DE-ALLOCATION");
	}
	
	

}
