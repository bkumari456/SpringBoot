package org.sanju;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvisor implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("additional concern before actual logic");  
		
	}  
   /* public void before(Method method, Object[] args, Object target)throws Throwable {  
        System.out.println("additional concern before actual logic");  
    } */ 
}  