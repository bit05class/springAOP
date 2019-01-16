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
	
	// After Returning Advice 입니다. // 이 어드바이스는 반환값을 받을 수 있습니다. 
	@AfterReturning(pointcut="commonPointcut()", returning="returnString") 
	public void afterReturningMethod(JoinPoint jp, String returnString) throws Exception { 
		log.info("afterReturningMethod() called....."); 
		// 호출된 메소드 반환값 출력 
		log.info("afterReturningMethod() returnString : " + returnString); 
	}

	// 예외가 발생했을때 Advice 입니다. 
	@AfterThrowing(pointcut="commonPointcut()", throwing="exception") 
	public void afterThrowingMethod(JoinPoint jp, Exception exception) throws Exception { 
		log.info("afterThrowingMethod() called....."); 
		// 발생한 예외의 메세지를 출력합니다. 
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
