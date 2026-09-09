package com.mainapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Employee {
	
	@Autowired
	private Account account;
	@Autowired
	@Qualifier("List2")
	private List<String> listofBooks;

	public Employee() {
		System.out.println("Employee BEAN INSTANTIATION : Zero parameterized...");
	}

	//@Autowired
	public Employee(Account account, List<String> listofBooks) {
		this.account = account;
		this.listofBooks = listofBooks;
	}
	
	public Account getAccount() {
		return account;
	}
	
	//@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	public List<String> getListofBooks() {
		return listofBooks;
	}

	//@Autowired
	public void setListofBooks(List<String> listofBooks) {
		this.listofBooks = listofBooks;
	}

	@Override
	public String toString() {
		return "Employee [account=" + account + ", listofBooks=" + listofBooks + "]";
	}
	
	
}



