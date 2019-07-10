package org.sanju;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethosInter implements MethodInterceptor {


	@Override
	public Object invoke(MethodInvocation m) throws Throwable {
		Object o;
		System.out.println("before method......");
		o=m.proceed();
		System.out.println("after method.....");
		return o;
	}

}
