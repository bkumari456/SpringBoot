package com.app.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee emp) {
		return repo.save(emp).getEmpId();
	}

	@Override
	public void deleteEmployee(Integer empId) {
		repo.deleteById(empId);
	}

	@Override
	public boolean isEmployeeExistById(Integer empId) {
		return repo.existsById(empId);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> emp=repo.findById(empId);
		if(emp.isPresent())
			return emp.get();
		else 
			return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps=repo.findAll();
		Collections.sort(emps, (e1,e2)->e1.getEmpId()-e2.getEmpId());
		return emps;
	}
}
