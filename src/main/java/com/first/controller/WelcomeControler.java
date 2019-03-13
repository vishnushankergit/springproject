package com.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.services.WelcomeServices;

@RestController
public class WelcomeControler {
	
	@Autowired
	private WelcomeServices services;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return services.getMessage();
	}

	
}
