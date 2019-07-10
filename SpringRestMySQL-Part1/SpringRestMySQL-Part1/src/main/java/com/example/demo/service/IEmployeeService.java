package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee emp);
	public Boolean isEmployeeExistById(Integer empId);
	public void deleteEmployee(Integer empId);
	
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getAllEmployees();
}
