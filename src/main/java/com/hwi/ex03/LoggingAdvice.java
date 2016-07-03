package com.hwi.ex03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable{
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD: " + methodName + " is calling.");
		Object rtnObj = invocation.proceed();
		
		sw.stop();
		
		System.out.println("[LOG] method: " + methodName + " was called");
		System.out.println("[LOG] 처리시간 : " + sw.getTotalTimeMillis() / 1000 + "초");
		
		return rtnObj;
	}
}
