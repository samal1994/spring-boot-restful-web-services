package com.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.HelloWorldBeans;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "hello";
	}
	
	
	@GetMapping(path="/helloworldBean")
	public HelloWorldBeans getBean() {
		HelloWorldBeans hb=new HelloWorldBeans("Suvendu Samal","suvendusibu@gmail.com","397MA092");
		//throw new RuntimeException("this is a server side exception ,contact support team");
		return hb;
	}
	
	@GetMapping(path="/pathvariable/{msg}")
	public HelloWorldBeans getPathVariables(@PathVariable("msg") String Message) {
		HelloWorldBeans hb=new HelloWorldBeans(Message,"suvendusamal@yahoo.in","1201227048");
		return hb;
	}
	
}
