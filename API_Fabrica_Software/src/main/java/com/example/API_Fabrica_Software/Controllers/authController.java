package com.example.API_Fabrica_Software.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.authiction.LoginRequestDTO;
import com.example.API_Fabrica_Software.DTO.authiction.RegisterRequestDTO;
import com.example.API_Fabrica_Software.DTO.authiction.ResponseDTO;
import com.example.API_Fabrica_Software.InfraSercurity.TokenService;
import com.example.API_Fabrica_Software.Model.ClassUsers;
import com.example.API_Fabrica_Software.Repository.RepositoryUser;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class authController {
 @Autowired
 private RepositoryUser repository;
 @Autowired
 private PasswordEncoder passwordEncoder;
 @Autowired
 private TokenService tokenService;

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {
  ClassUsers user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
  if (passwordEncoder.matches(body.password(), user.getPassword())) {
   String token = this.tokenService.generateToken(user);
   return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
  }
  return ResponseEntity.badRequest().build();
 }

 @PostMapping("/register")
 public ResponseEntity<?> register(@RequestBody RegisterRequestDTO body) {

  Optional<ClassUsers> user = this.repository.findByEmail(body.email());

  if (user.isEmpty()) {

   ClassUsers newUser = new ClassUsers();
   newUser.setPassoword(passwordEncoder.encode(body.password()));
   newUser.setEmail(body.email());
   newUser.setNome(body.name());

   this.repository.save(newUser);

   String token = this.tokenService.generateToken(newUser);
   return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
  }

  return ResponseEntity.badRequest().build();
 }

}
