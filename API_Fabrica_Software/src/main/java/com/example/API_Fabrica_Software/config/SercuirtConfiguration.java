package com.example.API_Fabrica_Software.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SercuirtConfiguration {
 public SecurityFilterChain securitFilterChan(HttpSecurity httpSecurity) throws Exception {
  return httpSecurity
    .csrf(AbstractHttpConfigurer::disable)
    .sessionManagement(session -> session.sessionCreationPolicy(
      SessionCreationPolicy.STATELESS))
    .authorizeHttpRequests(
      authoriza -> authoriza.requestMatchers(HttpMethod.GET, "/user").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST,"/user").permitAll()
        .anyRequest().authenticated())
    .build();
 }
}
