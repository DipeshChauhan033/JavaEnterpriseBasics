package com.mainapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainapp.config.MyConfiguration;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		
		Employee emp1 = ac.getBean(Employee.class);
		System.out.println(emp1);
		
	}

}
