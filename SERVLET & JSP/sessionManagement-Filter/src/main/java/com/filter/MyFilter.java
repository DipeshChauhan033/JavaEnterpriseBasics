package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		System.out.println("Filter Destroyed");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String header = req.getHeader("User-Agent").toLowerCase();
		System.out.println(header);
		
		if(!header.contains("chrome")) {
			res.getWriter().print("INVALID BROWSER");
			return;
		}
		
		long t1 = System.nanoTime();
		
		chain.doFilter(request, response);
		
		long t2 = System.nanoTime();
		System.out.println("TAKEN TIME: "+(t2-t1)+"ns");
		
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialized");
	}

}
