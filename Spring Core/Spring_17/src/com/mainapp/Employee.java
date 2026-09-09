package com.mainapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("#{42+62}")
	private int eid;
	
	//@Value("#{'raju'}")
	//@Value("#{test.testVar}")
	//@Value("#{T(com.mainapp.TestStatic).doTestStatic()}")
	private String ename;
	
	//@Value("#{test.doTest()==101 ? 'Valid' : 'Invalid'}")
	private String authenticationStatus;
	
	//@Value("#{environment['db.url']}")
	private String url;
	
	//@Value("#{{'Java','Python'}}")
	private List<String> listOfBooks;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public Employee(@Value("#{42+62}")int eid, @Value("#{T(com.mainapp.TestStatic).doTestStatic()}")String ename, @Value("#{test.doTest()==101 ? 'Valid' : 'Invalid'}")String authenticationStatus, @Value("#{environment['db.url']}")String url,@Value("#{{'Java','Python'}}") List<String> listOfBooks) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.authenticationStatus = authenticationStatus;
		this.url = url;
		this.listOfBooks = listOfBooks;
	}
	
	public int getEid() {
		return eid;
	}
	
	//@Value("#{42+62}")
	public void setEid(int eid) {
		this.eid = eid;
		System.out.println("EMP BEAN SETTER : EID");
	}

	public String getEname() {
		return ename;
	}
	
	//@Value("#{T(com.mainapp.TestStatic).doTestStatic()}")
	public void setEname(String ename) {
		this.ename = ename;
		System.out.println("EMP BEAN SETTER : ENAME");
	}

	public String getUrl() {
		return url;
	}
	
	//@Value("${db.url}")
	public void setUrl(String url) {
		this.url = url;
		System.out.println("EMP BEAN SETTER : URL");
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", authenticationStatus=" + authenticationStatus + ", url="
				+ url + ", listOfBooks=" + listOfBooks + "]";
	}
	
}



