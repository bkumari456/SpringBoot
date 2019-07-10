package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/rest/emp")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	//1. save data
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp){
		String message=null;
		ResponseEntity<String> response=null;
		try {
			Integer empId=service.saveEmployee(emp);
			message="Employee '"+empId+"' Saved";
			response=new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (Exception e) {
			message="Unable to save Employee:Reason"+e.getMessage();
			response=new ResponseEntity<String>(message,HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId){
		String message=null;
		ResponseEntity<String> response=null;
		try {
			if (empId==null) {
				message="Invalid Input Provided";
				response=new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
			}else if(service.isEmployeeExistById(empId)) {
				service.deleteEmployee(empId);
				message="Employee '"+empId+"' deleted";
				response=new ResponseEntity<String>(message,HttpStatus.OK);
			}else {
				message="Employee '"+empId+"' Not exist";
				response=new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			message="Unable to delete Employee:Reason"+e.getMessage();
			response=new ResponseEntity<String>(message,HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees(){
		String message=null;
		ResponseEntity<?> response=null;
		try {
			List<Employee> emps=service.getAllEmployees();
			if(emps==null || emps.size()==0) {
				message="No Data Found";
				response=new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
			}else {
				response=new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
			}
		} catch (Exception e) {
			message="Problem in Fetching data : reason is :"+e.getMessage();
			response=new ResponseEntity<String>(message,HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	
}