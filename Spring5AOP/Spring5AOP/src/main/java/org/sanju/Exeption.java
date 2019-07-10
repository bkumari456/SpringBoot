package org.sanju;

import org.springframework.aop.ThrowsAdvice;

public class Exeption implements ThrowsAdvice {

	
	public void afterThrowing(Exception ex){  
        System.out.println("additional concern if exception occurs:"+ex);  
	}
}
