package com.first.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Course")
public class Course {
		
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="topicId", insertable=false, updatable=false)
	private String topicId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	// @NotFound action = NotFoundAction.IGNORE will ignore if foreign key not found.
	
	@JoinColumn(name="topicId", nullable=true,insertable=false, updatable=false)
	private Topic topic;
	
	
	public Course() {
		
	}
		
	public Course(String id,String name,String detail,String topicId) {
		
		this.id=id;
		this.name=name;
		this.detail=detail;
		this.topicId= topicId;
		this.topic=new Topic(topicId," ","");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_topicId")
	
	private Topic topic;
	
	public Course() {		
	}
	


	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}*/

	
}
