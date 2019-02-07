package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advies for logging
	
	//start with @Before advice
	
	//@Before("execution(public void add*())")
//	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n ====>> executing Before addAccount() ");
//	}
	
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====>> executing Before addAccount() ");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n ====>> executing Before performApiAnalytics");
	} 
	
}