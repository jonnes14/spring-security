package com.jonnes.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(customizer-> customizer.disable()); //disable the csrf
            http.authorizeHttpRequests(request-> request.anyRequest().authenticated()); // to enable username and password
            http.formLogin(Customizer.withDefaults()); // no need form login becuase its stateless
            http.httpBasic(Customizer.withDefaults()); // to provide form login
            http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // to make sessionn stateless
            return http.build();
    }
}
