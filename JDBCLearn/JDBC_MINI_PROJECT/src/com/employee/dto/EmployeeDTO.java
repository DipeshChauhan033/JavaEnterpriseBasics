package com.employee.dto;

public class EmployeeDTO {
	private String uname;
	private String password;
	private String fullname;
	private String address;
	private double salary;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(String uname,String password,String fullname,String address,double salary){
		super();
		this.uname = uname;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.salary = salary;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
