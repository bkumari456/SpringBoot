package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	
	//1. to Show Register Page
	@GetMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	//2. save data on click submit
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
	
	//3. get Data form DB all rows
	@GetMapping("/viewAll")
	public String showData(ModelMap map) {
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("emps", emps);
		return "EmployeeData";
	}
	
	//4. Get Pagindation Data
	@GetMapping("/viewPage")
	public String showPageData(@PageableDefault(page=0,size=3,sort="empId",direction=Direction.ASC) Pageable pageable,ModelMap map) {
		Page<Employee> emps=service.getAllEmployees(pageable);
		map.addAttribute("page", emps);
		return "EmployeeData";
	}
	
	
	
	
	
	
	
}
