package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Employee e=(Employee)target;
		
		if(e.getEmpName()==null || "".equals(e.getEmpName().trim())){
			errors.rejectValue("empName",null, "Please enter Employee Name!!");
		}
		/*if(e.getEmpMail()==null || "".equals(e.getEmpMail().trim())) {*/
		if(StringUtils.isEmpty(e.getEmpMail()) || StringUtils.containsWhitespace(e.getEmpMail())) {
			errors.rejectValue("empMail",null, "Please enter Employee Mail Id!!");
		}
		if(StringUtils.isEmpty(e.getEmpGen()) || StringUtils.containsWhitespace(e.getEmpGen())) {
			errors.rejectValue("empGen",null, "Please choose one Gender !!");
		}
		if(StringUtils.isEmpty(e.getEmpAddr()) || StringUtils.containsWhitespace(e.getEmpAddr())) {
			errors.rejectValue("empAddr",null, "Please enter Employee Address !!");
		}
		if(e.getEmpLangs()==null || e.getEmpLangs().isEmpty()) {
			errors.rejectValue("empLangs",null, "Please choose at least one Language !!");
		}
		if(StringUtils.isEmpty(e.getEmpIdType())) {
			errors.rejectValue("empIdType",null, "Please Choose one Type !!");
		}
		if(StringUtils.isEmpty(e.getEmpIdNum()) || StringUtils.containsWhitespace(e.getEmpIdNum())) {
			errors.rejectValue("empIdNum",null, "Please Enter  ID Number !!");
		}
		
	}

	

}
