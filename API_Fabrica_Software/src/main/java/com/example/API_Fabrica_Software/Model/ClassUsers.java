package com.example.API_Fabrica_Software.Model;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//CLASSE DE INSTANCIA DE USUARIOS E A CRIAÇÃO DE TABELA DE USUARIOS

@Entity
@Table(name = "db_users")
public class ClassUsers implements UserDetails{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private String id;
 private String nome;

 @Column(nullable = false)
 private String email;
 private String passoword;
 
 @Column(nullable = false)
 private String roles;

 public ClassUsers(){

 }

 public ClassUsers(String id, String nome, String email, String passoword, String roles) {
  this.id = id;
  this.nome = nome;
  this.email = email;
  this.passoword = passoword;
  this.roles = roles;
 }

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }
 
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassoword() {
  return passoword;
 }

 public void setPassoword(String passoword) {
  this.passoword = passoword;
 }

 public String getRoles() {
  return roles;
 }

 public void setRoles(String roles) {
  this.roles = roles;
 }

 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
 }

 @Override
 public @Nullable String getPassword() {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
 }

 @Override
 public String getUsername() {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
 }

}
