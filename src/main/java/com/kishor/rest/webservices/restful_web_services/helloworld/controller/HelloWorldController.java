package com.kishor.rest.webservices.restful_web_services.helloworld.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kishor.rest.webservices.restful_web_services.helloworld.beans.HelloWorldBean;

//Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	
		
	@GetMapping( path = "/hello-world")
	public String getHelloWorld()
	{
		return "Hello World!";
	}
	
	@GetMapping( path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean()
	{
		//throw new RuntimeException("Something Error Occured, contact to support team !");
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping( path = "/hello-world-path-variable/{name}")
	public HelloWorldBean getHelloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}

}
