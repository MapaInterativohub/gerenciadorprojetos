package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class dtoAlunosRespost {
 private String emailInstitucional;
 private String nome;
 private String curso;
 private String projetoSelecionado;
 private String motivoDaInscricao;

 public dtoAlunosRespost(String emailInstitucional, String nome, String curso, String projetoSelecionado,
    String motivoDaInscricao) {
  this.emailInstitucional = emailInstitucional;
  this.nome = nome;
  this.curso = curso;
  this.projetoSelecionado = projetoSelecionado;
  this.motivoDaInscricao = motivoDaInscricao;
 }
 
 public String getEmailInstitucional() {
  return emailInstitucional;
 }
 public void setEmailInstitucional(String emailInstitucional) {
  this.emailInstitucional = emailInstitucional;
 }
 public String getNome() {
  return nome;
 }
 public void setNome(String nome) {
  this.nome = nome;
 }
 public String getCurso() {
  return curso;
 }
 public void setCurso(String curso) {
  this.curso = curso;
 }
 public String getProjetoSelecionado() {
  return projetoSelecionado;
 }
 public void setProjetoSelecionado(String projetoSelecionado) {
  this.projetoSelecionado = projetoSelecionado;
 }
 public String getMotivoDaInscricao() {
  return motivoDaInscricao;
 }
 public void setMotivoDaInscricao(String motivoDaInscricao) {
  this.motivoDaInscricao = motivoDaInscricao;
 }

 

}
