package com.udemy.springbootweb.section16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Section16Application {

	public static void main(String[] args) {
		SpringApplication.run(Section16Application.class, args);
	}

}
