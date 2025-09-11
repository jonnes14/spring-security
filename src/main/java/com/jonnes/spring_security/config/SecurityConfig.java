package com.jonnes.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                    .csrf(customizer-> customizer.disable()) //disable the csrf
                    .authorizeHttpRequests(request-> request
                            .requestMatchers("/register")
                            .permitAll()
                            .anyRequest()
                            .authenticated())

                     //.formLogin(Customizer.withDefaults()); // no need form login becuase its stateless

                     .httpBasic(Customizer.withDefaults()) // to provide form login
                     .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // to make sessionn stateless
            return http.build();
    }
    //below method is to authenticate multiple users
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user= User.withDefaultPasswordEncoder()
//                              .username("jonnes")
//                              .password("jonnes@1")
//                              .roles("USER")
//                              .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}
