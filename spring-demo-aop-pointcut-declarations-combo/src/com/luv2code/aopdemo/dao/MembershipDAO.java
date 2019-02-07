package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyAccount() {
		System.out.println(getClass() + " : Doing add menbership Account");
		return true;
	}
}
