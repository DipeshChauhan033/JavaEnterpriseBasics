package com.mainapp;

import org.springframework.stereotype.Component;

@Component("test")
public class Test {
	
	public String testVar="TestClassValue";
	
	public int doTest() {
		return 101;
	}

}
