package com.example.API_Fabrica_Software.Service.Auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationServices extends UserDetailsService{

 UserDetails loadUserByUsername(String login);
 
}
