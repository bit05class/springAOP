package com.bit.myapp.myaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvice implements MethodInterceptor{
//	implements MethodBeforeAdvice
	
//	@Override
//	public void before(Method method, Object[] args, Object target) throws Throwable {
//		// TODO Auto-generated method stub
//		System.out.println("aop before aop ...");
//	}//implements org.aopalliance.intercept.MethodInterceptor{

	Logger log=LoggerFactory.getLogger(MyAdvice.class);
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj=null;
		try {
		log.debug("aop before...");
		obj = invocation.proceed();
		log.debug("aop after...");
		}catch (Exception e) {
			System.out.println("aop exception...");
		}
		return obj;
	}

}
