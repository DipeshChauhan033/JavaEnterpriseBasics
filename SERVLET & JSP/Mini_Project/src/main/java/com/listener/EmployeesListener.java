package com.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.*;



@WebListener
public class EmployeesListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	try {
	         ServletContext servletcontext = sce.getServletContext();
	         //String realPath = servletcontext.getRealPath("/WEB-INF/config/config.properties");
	         //System.out.println(realPath);
	         
	         InputStream is = servletcontext.getResourceAsStream("/WEB-INF/config/config.properties");
	         Properties properties = new Properties();
	         properties.load(is);
	         
	         String url = (String) properties.get("db.url");
	         String username = (String) properties.get("db.username");
	         String password = (String) properties.get("db.password");
	         String driver = (String) properties.get("db.driver");
	         
	         ConnectionFactory.init(url, username, password, driver);
	         
	         EmployeesDAO employeesDAO = new EmployeesDAOimpl();
	         employeesDAO.createTable();
    	}
    	catch(Exception e) {
    		e.printStackTrace();	
    	}
    }
	
}
