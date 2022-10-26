package com.bridgelabz.fundooapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping()
public class Controller {

	@GetMapping()
	public String hello()   
	{  
	return "Hello User";  
	}  
}