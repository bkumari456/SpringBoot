package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);
	public void saveEmployees(Collection<Employee> e);
	
	public void deleteEmployeeById(Integer empId);
	public void deleteAllEmployees();
	
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getAllEmployees();
	public List<Employee> getFewEmployees(List<Integer> empIds);
	
	
}
