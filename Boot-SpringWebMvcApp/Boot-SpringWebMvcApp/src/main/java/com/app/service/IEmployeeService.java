package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.app.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee emp);
	public void deleteEmployee(Integer empId);
	public boolean isEmployeeExistById(Integer empId);
	
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getAllEmployees();
	
	//special methods
	public Page<Employee> getAllEmployees(Pageable pageable);
	public Page<Employee> getAllEmployees(Specification<Employee> spec,Pageable pageable);
	
	
	
		
	
}
