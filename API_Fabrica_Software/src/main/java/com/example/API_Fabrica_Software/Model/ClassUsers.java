package com.example.API_Fabrica_Software.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "db_users")
public class ClassUsers implements UserDetails {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id; // ✅ CORRIGIDO

 private String nome;

 @Column(nullable = false, unique = true)
 private String email;

 @Column(nullable = false)
 private String password; // ✅ corrigido nome

 @Column(nullable = false)
 private String roles; // ex: ROLE_USER

 public void setId(Long id) {
  this.id = id;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public void setRoles(String roles) {
  this.roles = roles;
 }

 public ClassUsers() {
 }

 public ClassUsers(String nome, String email, String password, String roles) {
  this.nome = nome;
  this.email = email;
  this.password = password;
  this.roles = roles;
 }

 // ===== GETTERS E SETTERS =====

 public Long getId() {
  return id;
 }

 public String getNome() {
  return nome;
 }

 public String getEmail() {
  return email;
 }

 public String getRoles() {
  return roles;
 }

 // ===== MÉTODOS DO SPRING SECURITY =====

 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
  return List.of(new SimpleGrantedAuthority(roles));
  // ex: ROLE_USER
 }

 @Override
 public String getPassword() {
  return this.password; // ✅ OBRIGATÓRIO
 }

 @Override
 public String getUsername() {
  return this.email; // ✅ email como login
 }

 @Override
 public boolean isAccountNonExpired() {
  return true;
 }

 @Override
 public boolean isAccountNonLocked() {
  return true;
 }

 @Override
 public boolean isCredentialsNonExpired() {
  return true;
 }

 @Override
 public boolean isEnabled() {
  return true;
 }
}
