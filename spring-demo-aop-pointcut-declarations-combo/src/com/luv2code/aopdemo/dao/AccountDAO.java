package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String servieCode;
	
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing my DB work: add An Account");
	}

	public String getName() {
		System.out.println(getClass() + " getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +" SetName");
		this.name = name;
	}

	public String getServieCode() {
		System.out.println(getClass() +" getServiceCode");
		return servieCode;
	}

	public void setServieCode(String servieCode) {
		System.out.println(getClass() +" setServiceCode");
		this.servieCode = servieCode;
	}
	
}
