package com.bit.myapp.myaop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice2{
	Logger log=LoggerFactory.getLogger(MyAdvice2.class);
	
	@Pointcut("execution(* com.bit.myapp.model.*Dao.func01(..))")
	public void commonPointcut() { }
	
	@Before("commonPointcut()")
	public void beforeMethod(JoinPoint jp){ 
		log.info("beforeMethod() called....."); 
	}
	
	@After("commonPointcut()") 
	public void afterMethod(JoinPoint jp) throws Exception { 
		log.info("afterMethod() called....."); 
	}
	
	// After Returning Advice �Դϴ�. // �� �����̽��� ��ȯ���� ���� �� �ֽ��ϴ�. 
	@AfterReturning(pointcut="commonPointcut()", returning="returnString") 
	public void afterReturningMethod(JoinPoint jp, String returnString) throws Exception { 
		log.info("afterReturningMethod() called....."); 
		// ȣ��� �޼ҵ� ��ȯ�� ��� 
		log.info("afterReturningMethod() returnString : " + returnString); 
	}

	// ���ܰ� �߻������� Advice �Դϴ�. 
	@AfterThrowing(pointcut="commonPointcut()", throwing="exception") 
	public void afterThrowingMethod(JoinPoint jp, Exception exception) throws Exception { 
		log.info("afterThrowingMethod() called....."); 
		// �߻��� ������ �޼����� ����մϴ�. 
		log.info(exception.getMessage()); 
	}


	@Around("execution(* com.bit.myapp.model.*Dao.*02(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
	//public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
		log.info("aop before...");
		pjp.proceed();
		log.info("aop after...");
		}catch (Exception e) {
			System.out.println("aop exception...");
		}
		return pjp;
	}

}
