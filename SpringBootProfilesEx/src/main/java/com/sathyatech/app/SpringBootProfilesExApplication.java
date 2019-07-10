package com.sathyatech.app;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.sathyatech.app.service.IEmployeeService;


@SpringBootApplication

public class SpringBootProfilesExApplication implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(SpringBootProfilesExApplication.class, args);

	}
	
       @Autowired

	private IEmployeeService service;


	@Override


	public void run(String... args) throws Exception {
	
	System.out.println(service.getMessage());

		System.exit(0);

		
	}

}
