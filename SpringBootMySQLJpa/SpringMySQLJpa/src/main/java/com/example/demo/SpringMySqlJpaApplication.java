package com.example.demo;

import 
java.util.Arrays;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.example.demo.model.Employee;

import com.example.demo.service.IEmployeeService;


@SpringBootApplication

@EnableJpaRepositories

public class SpringMySqlJpaApplication implements CommandLineRunner{


	public static void main(String[] args) {

		SpringApplication.run(SpringMySqlJpaApplication.class, args);

	}
	
	
        @Autowired
	
        private IEmployeeService service;

	
@Override

	public void run(String... args) throws Exception {

	/*1.
             Employee emp=new Employee(20,"B",12.2);

		service.saveEmployee(emp);*/
		

	

          //2. /*service.saveEmployees(
Arrays.asList(
                			new Employee(11, "D", 5.5),

				       new Employee(12, "S", 8.5),

					new Employee(13, "Q", 9.5),

					new Employee(14, "T", 6.5),

					new Employee(15, "R", 7.5)
					));*/
		
	
	//3.

		/*Employee e=service.getEmployeeById(45);

		System.out.println(e);*/
	
       //4

	/*	List<Employee> emps=service.getAllEmployees();
	
        	for(Employee e:emps) {

			System.out.println(e);

		}
		
		
                 emps.forEach((e)->System.out.println(e));

		emps.forEach(System.out::println);*/


     //5
	
        	/*List<Employee> emps=service.getFewEmployees(Arrays.asList(12,14,20));

		emps.forEach(System.out::println);
		
		*/
	
    //6.
		/*service.deleteEmployeeById(20);*/
		

		System.exit(0);
	
   }

}
