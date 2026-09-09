package com.mainapp;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private int an = 101;
	private String bankName = "BOB";
	
	public Account() {
		System.out.println("ACCOUNT BEAN INSTANTIATION : Zero parameterized...");
	}

	public Account(int an, String bankName) {
		super();
		this.an = an;
		this.bankName = bankName;
		System.out.println("ACCOUNT BEAN INSTANTIATION : parameterized...");
	}

	public int getAn() {
		return an;
	}

	public void setAn(int an) {
		this.an = an;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Account [an=" + an + ", bankName=" + bankName + "]";
	}
	
}
