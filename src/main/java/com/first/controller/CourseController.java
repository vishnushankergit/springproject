package com.first.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.first.dao.Course;
import com.first.services.CallRestServices;
import com.first.services.CourseServices;
import com.first.services.WelcomeServices;

@RestController
public class CourseController {
	

	
	
	private List<Course> courseHardcoded = new ArrayList<Course>(Arrays.asList(
			new Course("1", "Spring Fremwork", "Spring description", "1"),
			new Course("2", "Java Fremwork", "Java description", "2"),
			new Course("3", "Hibrnate Fremwork", "Hibernate Description","3" )
			
			));
	
	
	@Autowired
	private WelcomeServices services;
	
	@Autowired
	private CourseServices courseServices;
	
	@Autowired
	private CallRestServices callservices;
	
	@ResponseStatus(value=HttpStatus.CONFLICT,
            reason="Data integrity violation")
	
	@RequestMapping("/course")
	public List<Course> geAllCourse(){
		
		System.out.println("-------callservices---- getDetail --"+callservices.getCourse().getDetail());
		
		return courseServices.geAllCourse();
	}
	@RequestMapping("/course/{id}")
	public Course getCourse(@PathVariable String id){		
		return courseServices.geCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addCourse",consumes = "text/plain",produces="text/plain")
	public void addCourse(@RequestBody Course course){
		
		System.out.println("-------CourseController------"+course);
		
		 courseServices.addCourse(courseHardcoded);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/course/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String id){		
		 courseServices.updateCourse(course, id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/course/{id}")
	public void deletTopic(@PathVariable String id){		
		 courseServices.deletCourse(id);
	}
}
