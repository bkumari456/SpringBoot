package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

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
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> empOp=repo.findById(empId);
		if(empOp.isPresent())
			return empOp.get();
		else 
			return null;

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps=repo.findAll(Sort.by("empId"));
		/*Collections.sort(emps,new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getEmpId()-o2.getEmpId();
			}
		});*/
		//Collections.sort(emps,(o1,o2)->o1.getEmpId()-o2.getEmpId());
		return emps;
	}

	
	@Override
	public Boolean isEmployeeExistById(Integer empId) {
		return repo.existsById(empId);
	}
}
