package com.MyListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Listener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("On Close");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("On Startup");
         ServletContext servletContext = sce.getServletContext();
         servletContext.setInitParameter("admin", "admin123")
;    }
	
}
