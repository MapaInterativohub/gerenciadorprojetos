package com.example.API_Fabrica_Software.Service.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;

public class ServiceAuth implements AuthenticationServices {
 @Value("${jwt.secret}")
 private String secret;
 @Value("${jwt.expiration}")
 private Integer time_token;
 @Value("${jwt.refresh-token}")
 private Integer time_refresh;

 @Autowired
 RepositoryUsuario repository;

 public UserDetails loadUserByUsername(String login) {
  return repository.findByLogin(login);
 }

 public String geraToken(Ususario usuario)
}
