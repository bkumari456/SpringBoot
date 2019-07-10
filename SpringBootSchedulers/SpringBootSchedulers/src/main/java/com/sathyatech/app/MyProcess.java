package com.sathyatech.app;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyProcess {

	private int count=1;
	
	//@Scheduled(initialDelay=5000,fixedDelay=2000)
	//@Scheduled(initialDelay=5000,fixedDelay=2000)
	@Scheduled(cron="12,35,55 * * * * *")
	public void doWork() {
		System.out.println("Start:"+count);
		System.out.println(new Date()+":Hello"+count);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date()+":Hello"+count);
		System.out.println("end:"+count);
		count++;
		
	}
}
