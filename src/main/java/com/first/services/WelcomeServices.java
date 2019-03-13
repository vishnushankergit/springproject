package com.first.services;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.first.dozer.Employee;
import com.first.dozer.TCSEmployee;

@Service
public class WelcomeServices {

	@Autowired
	Environment env;
	public String getMessage()
	{
		System.out.println("*************environment is "+env.getProperty("environment"));
		DozerBeanMapper mapper; 
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(Arrays.asList("dozer_mapping.xml"));
	    
	    Employee employee = new Employee(123, "Vishnu", 70);
	    TCSEmployee tcsEmployee = mapper.map(employee, TCSEmployee.class);
	    
	    System.out.println("----getName -------> "+employee.getName()+
				"------getName -----"+tcsEmployee.getName());
	    
	    System.out.println("----getId -------> "+employee.getId()+
				"------getId -----"+tcsEmployee.getId());
	    
	    System.out.println("----getSalary -------> "+employee.getSalary()+
	    				"------getTcsSaliry -----"+tcsEmployee.getTcsSaliry());
	    
		return "Print Vishnu";			
	}
}
