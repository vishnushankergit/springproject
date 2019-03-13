package com.first.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.first.dao.Course;
@Service
public class CallRestServices {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Course getCourse() {
		return this.restTemplate.getForObject("http://localhost:8070/course/1", Course.class);
	}
}
