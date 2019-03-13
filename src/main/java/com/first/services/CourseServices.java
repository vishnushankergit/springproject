package com.first.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.first.dao.Course;
import com.first.repository.CourseRepository;
@Service
public class CourseServices {

	@Autowired
	Environment env;
	
	@Autowired
	CourseRepository repository;
	
	public List<Course> geAllCourse()
	{
		List<Course> courses = new ArrayList<Course>() ;	
		System.out.println("---------------------inside geAllCourse        "+repository.getClass());
		repository.findAll().forEach(courses::add);
		System.out.println("------------------courses      "+courses.size());
		return courses;
	}
	public Course geCourse(String id)
	{
		//return Course.stream().filter(t ->t.getId().equals(id)).findFirst().get();	
		return repository.findOne(id);
	}
	public void addCourse(List<Course> courses) {
		// TODO Auto-generated method stub
		
		System.out.println("-----addCourse --------"+courses);
		repository.save(courses);
		//Course.add(Courses);
	}
	public void updateCourse(Course courses,String id) {
		// TODO Auto-generated method stub
		repository.save(courses);
	}
	public void deletCourse(String id) {
		repository.delete(id);
		// TODO Auto-generated method stub
		/*for(int i=0;i<Course.size();i++) {
			
			if(Course.get(i).getId().equalsIgnoreCase(id)) {
				
				Course.remove(i);
				break;
			}
		}*/
	}
}
