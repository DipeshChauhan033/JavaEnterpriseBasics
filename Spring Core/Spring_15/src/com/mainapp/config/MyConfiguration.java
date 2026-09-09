package com.mainapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.mainapp"})
public class MyConfiguration {
	
	@Bean("List1")
	@Primary
	public List<String> listofbooks(){	
		ArrayList<String> al = new ArrayList<String>();
		al.add("Python");
		al.add("Java");
		al.add("C++");
		return al;
	}
	
	@Bean("List2")
	public List<String> listofbooks2(){	
		ArrayList<String> al = new ArrayList<String>();
		al.add("PHP");
		al.add("JS");
		al.add("Node JS");
		return al;
	}
	
	@Bean("List3")
	public List<String> listofbooks3(){	
		ArrayList<String> al = new ArrayList<String>();
		al.add("React JS");
		al.add("Express");
		al.add("Mongo DB");
		return al;
	}
	
	
}

