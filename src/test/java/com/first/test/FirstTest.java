package com.first.test;
import java.util.Arrays;

import org.apache.camel.test.junit4.CamelTestSupport;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.first.dozer.Employee;
import com.first.dozer.TCSEmployee;

public class FirstTest extends CamelTestSupport {
	
	DozerBeanMapper mapper;
	Logger logger = LoggerFactory.getLogger(FirstTest.class);
	
	@Before
	public void before() throws Exception {
		System.out.println("--------before ---> ");
		logger.info("--------before ---> ");
		
	    mapper = new DozerBeanMapper();
	}
	@Test
	public void testClass() {
		
		logger.info("--------before ---> ");	
		configureMapper("dozer_mapping.xml");	    
	    Employee employee = new Employee(123, "Vishnu", 70);
	    TCSEmployee tcsEmployee = mapper.map(employee, TCSEmployee.class);
	    
	    System.out.println("-----------> "+employee.getId()+ "-----------"+tcsEmployee.getId());
	    assertEquals(employee.getId(), tcsEmployee.getId());

	    //assertEquals(employee.getName(), tcsEmployee.getName());

	}
	public void configureMapper(String mappingFileUrls) {
		System.out.println("--------mappingFileUrls ---> "+mappingFileUrls);
	    mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
	}
}
