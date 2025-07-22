package com.udemy.springbootweb.section17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Section17Application {

	public static void main(String[] args) {
		SpringApplication.run(Section17Application.class, args);
	}

}
