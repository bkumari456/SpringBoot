package org.sanju;

import org.springframework.aop.framework.ProxyFactoryBean;

public class Client {
public static void main(String[] args) {
	ProxyFactoryBean fb=new ProxyFactoryBean();
	Bank b= new Bank();
	BeforeAdvisor ba=new BeforeAdvisor();
	AfterReturing aa=new AfterReturing();
	
	MethosInter m=new MethosInter();
	
	
	/*fb.setTarget(b);
	fb.addAdvice(m);
	Bank bb=(Bank) fb.getObject();
	bb.m1();
	*/
	Validate v=new Validate();
	Exeption e=new Exeption();
	
	fb.setTarget(v);
	fb.addAdvice(e);
	Validate bb=(Validate) fb.getObject();
	try {
		bb.validate(19);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	};
}
	
}
