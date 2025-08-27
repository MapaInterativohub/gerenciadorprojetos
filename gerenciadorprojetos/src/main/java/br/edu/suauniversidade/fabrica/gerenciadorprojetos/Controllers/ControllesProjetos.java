package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService.ServiceDeleteProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService.ServiceGetProjeto;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService.ServiceGetProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService.ServicePostProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService.ServicePutProjetos;
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
