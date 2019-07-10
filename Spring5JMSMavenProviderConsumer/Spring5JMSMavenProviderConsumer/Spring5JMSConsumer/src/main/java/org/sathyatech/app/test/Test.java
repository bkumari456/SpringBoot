package org.sathyatech.app.test;

import org.sathyatech.app.config.AppConfig;
import org.sathyatech.app.listener.MyMessageListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		MyMessageListener ms=ac.getBean(MyMessageListener.class);
	}
}
