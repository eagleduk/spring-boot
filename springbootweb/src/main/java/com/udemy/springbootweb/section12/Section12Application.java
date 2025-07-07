package com.udemy.springbootweb.section12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Section12Application {

	public static void main(String[] args) {
		SpringApplication.run(Section12Application.class, args);
	}

	@Bean
	public WebMvcConfigurer setConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("EFEFEJIFEO");
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:5173");
			}
		};
	}

}
