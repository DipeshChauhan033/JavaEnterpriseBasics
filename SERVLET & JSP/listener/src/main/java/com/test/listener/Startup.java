package com.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class Startup implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("Table Deleted");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Table Created");
    }
	
}
