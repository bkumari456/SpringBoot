package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeValidator validator;
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	@PostMapping("/insert")
	public String saveEmp(@ModelAttribute Employee employee,Errors errors,ModelMap map) {
		validator.validate(employee, errors);
		if(errors.hasErrors()) {
			map.addAttribute("employee", employee);
		}else {
			Integer empId=service.saveEmployee(employee);
			map.addAttribute("message", "Employee '"+empId+"' created");
			//clear form
			map.addAttribute("employee", new Employee());
		}
		return "EmployeeRegister";
	}
	
	
	
	
}
