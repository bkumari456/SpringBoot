package com.sathyatech.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("etrans-prof")
public class EtransEmployeeServiceImpl implements IEmployeeService {

	@Value("${myapp.message}")
	private String myTitle;
	
	@Override
	public String getMessage() {
		return "From E-Trans:"+myTitle;
	}

}
