package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_users")

public class ClassProjetos {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nomeDoProjeto;
 private String descricaoDoProjeto;
 private String areaDeConhecimento;
 private Date dataDeInicioDoProjeto;
 private Date dataDoFimDoProjeto;
 private String alunosParticipantesDoProjeto;
 private String linkGit;
 private String linkImage;

 public ClassProjetos(){

 }

 public ClassProjetos(Long id, String nomeDoProjeto, String descricaoDoProjeto, String areaDeConhecimento,
   Date dataDeInicioDoProjeto, Date dataDoFimDoProjeto, String alunosParticipantesDoProjeto, String linkGit,
   String linkImage) {
  this.id = id;
  this.nomeDoProjeto = nomeDoProjeto;
  this.descricaoDoProjeto = descricaoDoProjeto;
  this.areaDeConhecimento = areaDeConhecimento;
  this.dataDeInicioDoProjeto = dataDeInicioDoProjeto;
  this.dataDoFimDoProjeto = dataDoFimDoProjeto;
  this.alunosParticipantesDoProjeto = alunosParticipantesDoProjeto;
  this.linkGit = linkGit;
  this.linkImage = linkImage;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNomeDoProjeto() {
  return nomeDoProjeto;
 }

 public void setNomeDoProjeto(String nomeDoProjeto) {
  this.nomeDoProjeto = nomeDoProjeto;
 }

 public String getDescricaoDoProjeto() {
  return descricaoDoProjeto;
 }

 public void setDescricaoDoProjeto(String descricaoDoProjeto) {
  this.descricaoDoProjeto = descricaoDoProjeto;
 }

 public String getAreaDeConhecimento() {
  return areaDeConhecimento;
 }

 public void setAreaDeConhecimento(String areaDeConhecimento) {
  this.areaDeConhecimento = areaDeConhecimento;
 }

 public Date getDataDeInicioDoProjeto() {
  return dataDeInicioDoProjeto;
 }

 public void setDataDeInicioDoProjeto(Date dataDeInicioDoProjeto) {
  this.dataDeInicioDoProjeto = dataDeInicioDoProjeto;
 }

 public Date getDataDoFimDoProjeto() {
  return dataDoFimDoProjeto;
 }

 public void setDataDoFimDoProjeto(Date dataDoFimDoProjeto) {
  this.dataDoFimDoProjeto = dataDoFimDoProjeto;
 }

 public String getAlunosParticipantesDoProjeto() {
  return alunosParticipantesDoProjeto;
 }

 public void setAlunosParticipantesDoProjeto(String alunosParticipantesDoProjeto) {
  this.alunosParticipantesDoProjeto = alunosParticipantesDoProjeto;
 }

 public String getLinkGit() {
  return linkGit;
 }

 public void setLinkGit(String linkGit) {
  this.linkGit = linkGit;
 }

 public String getLinkImage() {
  return linkImage;
 }

 public void setLinkImage(String linkImage) {
  this.linkImage = linkImage;
 }
}
