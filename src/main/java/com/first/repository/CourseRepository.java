package com.first.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.first.dao.Course;


@Repository
public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByName(String courseName);
	
	
}
