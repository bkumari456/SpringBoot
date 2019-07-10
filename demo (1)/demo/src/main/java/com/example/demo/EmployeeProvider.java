package com.example.demo;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeProvider {

	@Value("${server.port}")
	private String myPort;
	
	@GetMapping("/show")
	public String show(){
		return "hello : running on port no:"+myPort;
	}
	
	@GetMapping("/showEmp")
	public Employee empDetails(){
		
		Employee e=new Employee();
		e.setEmpId(101);
		e.setEmpName("abc");
		e.setEmpSal(10.25);
		
		return e;
		
	}
	
	@GetMapping("/showAll")
	public List<Employee> empDetailsAll(){
		
		List<Employee> list=Arrays.asList(
				new Employee(10,"a",10.20),
				new Employee(12,"b",15.20),
				new Employee(14,"a",12.20),
				new Employee(17,"a",18.20)
				
				);
		
		return list;
		
	}
}
