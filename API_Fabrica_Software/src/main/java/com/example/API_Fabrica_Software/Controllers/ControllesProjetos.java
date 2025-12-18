package com.example.API_Fabrica_Software.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import com.example.API_Fabrica_Software.DTO.ProjetoDTO.dtoProjetoPost;
import com.example.API_Fabrica_Software.DTO.ProjetoDTO.dtoProjetoResp;
import com.example.API_Fabrica_Software.Repository.RepositoryAlunos;
import com.example.API_Fabrica_Software.Repository.RepositoryProjetos;
import com.example.API_Fabrica_Software.Service.ProjetoService.ServiceDeleteProjetos;
import com.example.API_Fabrica_Software.Service.ProjetoService.ServiceGetProjeto;
import com.example.API_Fabrica_Software.Service.ProjetoService.ServiceGetProjetos;
import com.example.API_Fabrica_Software.Service.ProjetoService.ServicePostProjetos;
import com.example.API_Fabrica_Software.Service.ProjetoService.ServicePutProjetos;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = "*")
public class ControllesProjetos {
  @Autowired
  RepositoryProjetos repositorioProjetos;

  @Autowired
  RepositoryAlunos repositoryAlunos;

  @Autowired
  ServicePostProjetos servicePostProjetos;

  @Autowired
  ServicePutProjetos servicePutProjetos;

  @Autowired
  ServiceGetProjetos serviceGetProjetos;

  @Autowired
  ServiceDeleteProjetos serviceDeleteProjetos;

  @Autowired
  ServiceGetProjeto serviceGetProjeto;

  @PostMapping("/addprojetos")
  public ResponseEntity<dtoProjetoResp> CreatinProjeto(@RequestBody dtoProjetoPost DTO) {
    ResponseEntity<dtoProjetoResp> gestore = servicePostProjetos.postProjeto(DTO);
    return gestore;
  }

  @GetMapping("/getprojetos")
  public List<dtoProjetoResp> GetProjeto() {
    return serviceGetProjetos.getProjetos();
  }

 @GetMapping("/getprojetos/{identicadorProjetos}")
 public ResponseEntity<dtoProjetoResp> GetProjetoId(@PathVariable String identicadorProjetos) {

  ResponseEntity<dtoProjetoResp> service = serviceGetProjeto.getProjeto(identicadorProjetos);

  return service;
 }

 @PutMapping("/{identicadorProjetos}")
 @Transactional
 public ResponseEntity<dtoProjetoAtulizacaoInfomacao> updateProjetos(@PathVariable String identicadorProjetos,
   @RequestBody dtoProjetoAtulizacaoInfomacao projeto) {
  ResponseEntity<dtoProjetoAtulizacaoInfomacao> dtoProjetoRes = servicePutProjetos.putProjeto(identicadorProjetos,
    projeto);

  return dtoProjetoRes; // Melhor retornar o produto atualizado
 }

  @DeleteMapping("/{identicadorProjetos}")
  public ResponseEntity<dtoProjetoResp> DeleteProduct(@PathVariable String identicadorProjetos) {
    ResponseEntity<dtoProjetoResp> serveice = serviceDeleteProjetos.deleteProjeto(identicadorProjetos);

    return serveice;
  }

}
