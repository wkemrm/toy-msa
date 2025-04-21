package com.example.userservice.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable());
        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/user-service/**").permitAll()
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                );
        http.headers(
                headers -> headers.frameOptions(frame -> frame.disable())
        );
        return http.build();
    }
}
