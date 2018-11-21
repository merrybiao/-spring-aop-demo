package com.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysLogAop {
	
	@Pointcut("@annotation(com.hello.annotation.SysLog)")
	public void LogAspect() {
	}

	@AfterThrowing(pointcut = "LogAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint point, Throwable e) throws Exception {
		System.out.println("异常处理");
	}

	@Around("LogAspect()")
	public Integer doAround(ProceedingJoinPoint point) throws Throwable {
		Integer result = (Integer) point.proceed();
		System.out.println("环绕");
		return result;
	}
}
