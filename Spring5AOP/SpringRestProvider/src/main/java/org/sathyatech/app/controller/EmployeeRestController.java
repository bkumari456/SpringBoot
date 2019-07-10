package org.sathyatech.app.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.sathyatech.app.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	private Set<Employee> emps=new HashSet<Employee>();
	
	@GetMapping("/all")
	public ResponseEntity<Set<Employee>> getAllEmployees() {
		return new ResponseEntity<Set<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/id/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer empId) {
		Iterator<Employee> it=emps.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			if(employee.getEmpId()==empId) {
				return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
		Iterator<Employee> it=emps.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			if(employee.getEmpId()==emp.getEmpId()) {
				return new ResponseEntity<String>("Employee alread Exist",HttpStatus.BAD_REQUEST);
			}
		}
		emps.add(emp);
		return new ResponseEntity<String>("Employee saved",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) {
		boolean flag=false;
		Iterator<Employee> it=emps.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			if(employee.getEmpId()==empId) {
				it.remove();
				flag=true;
			}
		}
		return flag?
				new ResponseEntity<String>("Employee Deleted",HttpStatus.OK):
					new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		boolean flag=false;
		Iterator<Employee> it=emps.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			if(employee.getEmpId()==emp.getEmpId()) {
				it.remove();
				emps.add(emp);
				flag=true;
			}
		}
		return flag?
				new ResponseEntity<String>("Employee Updated",HttpStatus.OK):
					new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
	}
	
}