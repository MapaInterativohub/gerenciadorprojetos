package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO;

import java.util.Date;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;

public class dtoProjetos {
 private String nomeDoProjeto;
 private String descricaoDoProjeto;
 private String areaDeConhecimento;
 private Date dataDeInicioDoProjeto;
 private Date dataDoFimDoProjeto;
 private String alunosParticipantesDoProjeto;
 private String linkGit;
 private String linkImage;
 
 public dtoProjetos(){

 }

 public dtoProjetos(ClassProjetos classProjetos) {
  this.nomeDoProjeto = classProjetos.getNomeDoProjeto();
  this.descricaoDoProjeto = classProjetos.getDescricaoDoProjeto();
  this.areaDeConhecimento = classProjetos.getAreaDeConhecimento();
  this.dataDeInicioDoProjeto = classProjetos.getDataDeInicioDoProjeto();
  this.dataDoFimDoProjeto = classProjetos.getDataDoFimDoProjeto();
  this.alunosParticipantesDoProjeto = classProjetos.getAlunosParticipantesDoProjeto();
  this.linkGit = classProjetos.getLinkGit();
  this.linkImage = classProjetos.getLinkImage();
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
