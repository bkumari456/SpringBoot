package com.example.demo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	@Override
	public Integer saveEmployee(Employee e) {
		Integer empId=repo.save(e).getEmpId();
		return empId;
	}
	
	@Override
	public void saveEmployees(Collection<Employee> emp) {
		repo.saveAll(emp);
	}
	
	@Override
	public void deleteEmployeeById(Integer empId) {
		repo.deleteById(empId);
	}

	@Override
	public void deleteAllEmployees() {
		repo.deleteAll();
	}
	
	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> ob=repo.findById(empId);
		if(ob.isPresent())
			return ob.get();
		else 
			return null;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	@Override
	public List<Employee> getFewEmployees(List<Integer> empIds) {
		return repo.findAllById(empIds);
	}
	
	
	
	
	
	
}
