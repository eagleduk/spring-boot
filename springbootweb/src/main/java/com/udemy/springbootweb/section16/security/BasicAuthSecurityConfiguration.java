package com.udemy.springbootweb.section16.security;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // security 가 제공하는 /login, /logout 페이지 접근 해제 (Form 인증 해제)
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                // Basic 인증 사용
                .httpBasic(Customizer.withDefaults())
                // Session 설정
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Csrf 보안 해제
                .csrf(CsrfConfigurer::disable);

        return http.build();
    }
}
