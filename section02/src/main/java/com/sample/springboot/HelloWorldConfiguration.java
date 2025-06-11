package com.sample.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Eliminate verbosity in creating Java Beas
// Public accessor method, constructor,
// equals, hashcode and toString are automatically created.
// Released in JDK 16.

record Person(String name, int age) {}

record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Hello World";
    }

    @Bean
    public int age() {
        return 21;
    }

    @Bean
    public Person person() {
        return new Person("Ronaldo", 40);
    }

    @Bean
    public Address address() {
        return new Address("Gangnam", "Seoul");
    }
}
