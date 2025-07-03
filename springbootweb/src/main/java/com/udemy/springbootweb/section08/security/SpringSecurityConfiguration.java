package com.udemy.springbootweb.section08.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // 모든 endpoint 인증 처리
        httpSecurity.authorizeHttpRequests(http -> http.anyRequest().authenticated());

        // Basic 인증 처리
        httpSecurity.httpBasic(Customizer.withDefaults());

        // CSRF 해제
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        
        return httpSecurity.build();
    }
}
