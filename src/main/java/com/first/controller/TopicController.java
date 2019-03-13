package com.first.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.first.dao.Topic;
import com.first.services.TopicServices;
import com.first.services.WelcomeServices;

@RestController
public class TopicController {
	
	@Autowired
	private WelcomeServices services;
	
	@Autowired
	private TopicServices topicServices;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic(){		
		return topicServices.geAllTopic();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Integer id){		
		return topicServices.geTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topics){
		
		System.out.println("-------TopicController------"+topics);
		 topicServices.addTopic(topics);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topics,@PathVariable String id){		
		 topicServices.updateTopic(topics,id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deletTopic(@PathVariable String id){		
		 topicServices.deletTopic(id);
	}
}
