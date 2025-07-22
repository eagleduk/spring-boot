package com.udemy.springbootweb.section17;

import com.udemy.springbootweb.section17.aop.business.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Section17Application implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService1 businessService1;

	public Section17Application(BusinessService1 b) {
		this.businessService1 = b;
	}

	public static void main(String[] args) {
		SpringApplication.run(Section17Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Max Value:: {} ", businessService1.getMax());
	}
}
