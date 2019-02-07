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
	
	//create pointcut for getter 
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {		
	}
	//create pointcut for setter
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}
	
	//combine
	@Pointcut("forDaoPackage() && ! (getter()|| setter())")
	private void forDaoPackageNoGetAndSet() {
	}
	
	@Before("forDaoPackageNoGetAndSet()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====>> executing Before addAccount() ");
	}
	
	@Before("forDaoPackageNoGetAndSet()")
	public void performApiAnalytics() {
		System.out.println("\n ====>> executing Before performApiAnalytics");
	} 
	
}
