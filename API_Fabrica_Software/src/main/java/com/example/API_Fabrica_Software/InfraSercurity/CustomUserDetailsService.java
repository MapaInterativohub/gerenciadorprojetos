package com.example.API_Fabrica_Software.InfraSercurity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.API_Fabrica_Software.Model.ClassUsers;
import com.example.API_Fabrica_Software.Repository.RepositoryUser;
@Component
public class CustomUserDetailsService implements UserDetailsService {
 @Autowired
 RepositoryUser repositoryUser;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  ClassUsers user = this.repositoryUser.findByEmail(username)
    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassoword(), new ArrayList<>());
 }

}