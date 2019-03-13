package com.first.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.first.dao.Topic;
import com.first.repository.TopicRepository;

@Service
public class TopicServices {

	@Autowired
	Environment env;
	
	@Autowired
	TopicRepository repository;
	
/*	private List<Topic> topices = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Fremwork", "Spring description"),
			new Topic("java", "Java Fremwork", "Java description"),
			new Topic("Hibernate", "Hibrnate Fremwork", "Hibernate Description")
			
			));*/
	public List<Topic> geAllTopic()
	{
		List<Topic> topices = new ArrayList<Topic>() ;	
		repository.findAll().forEach(topices::add);
		return topices;
	}
	public Topic geTopic(Integer id)
	{
		//return topices.stream().filter(t ->t.getId().equals(id)).findFirst().get();	
		return repository.findOne(Integer.toString(id));
	}
	public void addTopic(Topic topics) {
		// TODO Auto-generated method stub
		
		System.out.println("-----TopicServices --------"+topics);
		repository.save(topics);
		//topices.add(topics);
	}
	public void updateTopic(Topic topics,String id) {
		// TODO Auto-generated method stub
		repository.save(topics);
	}
	public void deletTopic(String id) {
		repository.delete(id);
		// TODO Auto-generated method stub
		/*for(int i=0;i<topices.size();i++) {
			
			if(topices.get(i).getId().equalsIgnoreCase(id)) {
				
				topices.remove(i);
				break;
			}
		}*/
	}
}
