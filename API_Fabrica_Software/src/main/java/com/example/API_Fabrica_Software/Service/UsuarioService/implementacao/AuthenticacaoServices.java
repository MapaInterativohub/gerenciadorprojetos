package com.example.API_Fabrica_Software.Service.UsuarioService.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;

public class AuthenticacaoServices implements UserDetailsService {

 @Autowired
 RepositoryUsuario repositoryUsuario;

 @Override
 public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
  // TODO Auto-generated method stub
  return repositoryUsuario.findByLogin(login);
 }

}
