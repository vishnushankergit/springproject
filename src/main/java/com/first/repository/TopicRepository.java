package com.first.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.first.dao.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>{

}
