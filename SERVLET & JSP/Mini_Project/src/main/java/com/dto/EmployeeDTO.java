package com.dto;

public class EmployeeDTO {
	private String ename;
	private String address;
	private int age;
	private double salary;
	private int id_no;
	
	public EmployeeDTO(String ename, String address, int age, double salary) {
		super();
		this.ename = ename;
		this.address = address;
		this.age = age;
		this.salary = salary;
	}
	
	public EmployeeDTO(int id_no) {
		super();
		this.id_no = id_no;
	}


	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [ename=" + ename + ", address=" + address + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}
