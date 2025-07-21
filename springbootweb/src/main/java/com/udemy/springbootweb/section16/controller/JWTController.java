package com.udemy.springbootweb.section16.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class JWTController {

    private JwtEncoder jwtEncoder;

    public JWTController(JwtEncoder j) {
        this.jwtEncoder = j;
    }

    @PostMapping("/auth")
    public JwtResponse authenticate(Authentication auth) {
        return new JwtResponse(createToken(auth));
    }

    private String createToken(Authentication auth) {

        JwtClaimsSet build = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 10))
                .subject(auth.getName())
                .claim("scope", createScope(auth))
                // custom parameter
                .claim("TEST", "EJIFE")
                .build();

        JwtEncoderParameters p = JwtEncoderParameters.from(build);
        return jwtEncoder.encode(p).getTokenValue();

    }

    private String createScope(Authentication auth) {
        return auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }
}

record JwtResponse(String token) {};
