package com.udemy.springboot.section02.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Eliminate verbosity in creating Java Beas
// Public accessor method, constructor,
// equals, hashcode and toString are automatically created.
// Released in JDK 16.

record Person(String name, int age, Address address) {}

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
        return new Person("Ronaldo", 40, new Address("Seocho", "Seoul"));
    }

    @Bean(name = "personMethod")
    public Person person2() {
        return new Person(name(), age(), address2());
    }

    @Bean(name = "personParameter")
    public Person person3(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "personQualifier")
    public Person person4(String name, int age, @Qualifier("addressQualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean
    @Primary
    public Address address2() {
        return new Address("Gangnam", "Seoul");
    }
    @Bean
    @Qualifier("addressQualifier")
    public Address address3() {
        return new Address("Songpa", "Seoul");
    }
}
