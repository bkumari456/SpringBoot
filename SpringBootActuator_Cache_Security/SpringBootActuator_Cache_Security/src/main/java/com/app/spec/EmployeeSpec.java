package com.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.model.Employee;

@SuppressWarnings("serial")
public class EmployeeSpec implements Specification<Employee>{

	//filter -> search screen data
	private Employee filter;
	
	public EmployeeSpec(Employee filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		Predicate p=cb.conjunction(); //and
		//cb.disjunction() ; //or
		
		if(filter.getEmpId()!=null && filter.getEmpId()>0) {
			p.getExpressions()
			.add(
				cb.equal(root.get("empId"), filter.getEmpId())
			);
		}
		if(filter.getEmpName()!=null && !"".equals(filter.getEmpName().trim())) {
			p.getExpressions()
			.add(
				cb.like(root.get("empName").as(String.class), "%"+filter.getEmpName()+"%")	
			);
			
		}
		if(filter.getEmpMail()!=null && !"".equals(filter.getEmpMail().trim())) {
			p.getExpressions()
			.add(
				cb.like(root.get("empMail").as(String.class), "%"+filter.getEmpMail()+"%")
			);
		}
		
		
		return p;
	}
	
}
