package com.udemy.springbootweb.section13.helloworld;

import com.udemy.springbootweb.section12.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/login")
	public boolean login() {
		return true;
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World"; 
	}
	
	@GetMapping(path = "/hello-world-bean")
	public com.udemy.springbootweb.section12.helloworld.HelloWorldBean helloWorldBean() {
		return new com.udemy.springbootweb.section12.helloworld.HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public com.udemy.springbootweb.section12.helloworld.HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}	
}
