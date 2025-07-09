package com.udemy.springbootweb.section12.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // 모든 endpoint 인증 처리
        return httpSecurity
                .authorizeHttpRequests(http -> http
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated()
                )
        // Basic 인증 처리
                .httpBasic(Customizer.withDefaults())

        // Session 정책
                .sessionManagement(c -> c.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                )
                        // 최대 Session 갯수     .maximumSessions(1)
                )

        // CSRF 해제
                .csrf(AbstractHttpConfigurer::disable)
        
                .build();
    }
}
