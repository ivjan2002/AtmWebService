package com.example.ATMBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Isključuje CSRF zaštitu (privremeno)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/auth/register").permitAll() // Omogućava registraciju bez autentifikacije
                        .anyRequest().authenticated() // Sve ostalo zahteva prijavu
                );
        return http.build();
    }
}
