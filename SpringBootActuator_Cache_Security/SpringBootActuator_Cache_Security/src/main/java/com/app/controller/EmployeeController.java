package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.spec.EmployeeSpec;
import com.app.validator.EmployeeValidator;


@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	private Logger log=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeValidator validator;
	
	@Autowired
	private IEmployeeService service;
	
	//1. to Show Register Page
	@GetMapping("/reg")
	public String showReg(ModelMap map) {
		log.info("Now in Show reg Method");
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
	public String showPageData(@PageableDefault(page=0,size=3,sort="empId",direction=Direction.ASC) Pageable pageable,@ModelAttribute Employee filter ,ModelMap map) {
		Specification<Employee> spec=new EmployeeSpec(filter);
		Page<Employee> emps=service.getAllEmployees(spec,pageable);
		map.addAttribute("page", emps);
		map.addAttribute("filter", filter);
		return "EmployeeData";
	}
	
	
	//5. delete employee byId
	@GetMapping("/delete")
	public String doDelete(@RequestParam("empId")Integer eid) {
		service.deleteEmployee(eid);
		//map.addAttribute("message", "Employee deleted successfully");
		return "redirect:viewPage";
	}
	
	//6. view One employee
	@GetMapping("/viewOne")
	public String viewOne(@RequestParam("empId")Integer  empId,ModelMap map) {
		Employee emp=service.getEmployeeById(empId);
		map.addAttribute("emp", emp);
		return "EmployeeView";
	}
	
	//7. show Edit page
	@GetMapping("/edit")
	public String showEdit(@RequestParam("empId")Integer empId,ModelMap map) {
		Employee e=service.getEmployeeById(empId);
		map.addAttribute("employee", e);
		return "EmployeeEdit";
	}
	
	
	//8. update employee
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee) {
		service.saveEmployee(employee);
		return "redirect:viewPage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}