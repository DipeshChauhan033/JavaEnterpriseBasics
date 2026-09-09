package com.mainapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("1000")
	private int eid;
	@Value("100")
	private String ename;
	@Value("${db.url}")
	private String url;
	
	public Employee() {
		System.out.println("EMP BEAN INSTANTIATION : ZPC");
	}

	public Employee(int eid, String ename, String url) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.url = url;
		System.out.println("EMP BEAN INSTANTIATION : PC");
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
		System.out.println("EMP BEAN SETTER : EID");
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
		System.out.println("EMP BEAN SETTER : ENAME");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		System.out.println("EMP BEAN SETTER : URL");
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", url=" + url + "]";
	}
	
	
	
}



