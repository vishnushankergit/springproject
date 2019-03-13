package com.first.vishnu;


import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.first")
// This is required for loading all classes, if this is not 
@EnableJpaRepositories("com.first.repository")
// if spring using Repository @EnableJpaRepositories is required for accessing it
@EntityScan("com.first.dao")
// This is required for loading entity else you may get not a managed type error.
@EnableJms

// it used to scan package for auto wired from different package.
public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("java2blog.queue");
	}
	@Bean
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
