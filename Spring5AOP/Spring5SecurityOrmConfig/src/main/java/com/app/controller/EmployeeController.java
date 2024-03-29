package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	
	//1. show Register Page
	@GetMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	//2. on click submit insert data to DB
	@PostMapping("/insert")
	public String saveEmp(@ModelAttribute Employee employee,ModelMap map) {
		Integer empId=service.saveEmployee(employee);
		map.addAttribute("message", "Employee '"+empId+"' created");
		map.addAttribute("employee",new Employee());
		return "EmployeeRegister";
	}
	
	
	//3. show Data at UI
	@GetMapping("/all")
	public String showData(ModelMap map) {
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("emps",emps);
		return "EmployeeData";
	}
	
	//4. delete employee By Id
	@GetMapping("/delete")
	public String delete(@RequestParam("empId")Integer empId,ModelMap map) {
		service.deleteEmployeeById(empId);
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("emps",emps);
		map.addAttribute("message", "Employee '"+empId+"' Deleted");
		return "EmployeeData";
	}
	
}
