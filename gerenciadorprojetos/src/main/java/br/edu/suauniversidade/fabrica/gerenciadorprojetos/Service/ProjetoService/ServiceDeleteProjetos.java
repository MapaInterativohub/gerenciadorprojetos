package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

@Service
public class ServiceDeleteProjetos {
 @Autowired
 RepositoryProjetos repositoryProjetos;

 public ResponseEntity<dtoProjetoResp> deleteProjeto(String codigoProjeto) {
  Optional<ClassProjetos> optionalProjeto =  repositoryProjetos.findByCodigoProjeto(codigoProjeto);
  if(!optionalProjeto.isPresent()){
   return ResponseEntity.badRequest().build();
  }

  ClassProjetos projetoSelecionado =  optionalProjeto.get();

  dtoProjetoResp res = new dtoProjetoResp();

  List<String> listaAlunos =  new ArrayList<>();
  for(ClassAlunos a: projetoSelecionado.getAlunosParticipantesDoProjeto()){
   listaAlunos.add(a.getRa());
  }

  List<String> listaGestores =  new ArrayList<>();
  for(ClassGestores g: projetoSelecionado.getProfesorOrientador()){
   listaGestores.add(g.getCodigoGestor());
  }

  res.setCodigoProjeto(projetoSelecionado.getCodigoProjeto());
  res.setNomeDoProjeto(projetoSelecionado.getNomeDoProjeto());
  res.setDescricaoDoProjeto(projetoSelecionado.getDescricaoDoProjeto());
  res.setAreaDeConhecimento(projetoSelecionado.getAreaDeConhecimento());
  res.setDataDeInicioDoProjeto(projetoSelecionado.getDataDeInicioDoProjeto());
  res.setDataDoFimDoProjeto(projetoSelecionado.getDataDoFimDoProjeto());
  res.setAlunosParticipantesDoProjeto(listaAlunos);
  res.setProfesorOrientador(listaGestores);
  res.setLinkGit(projetoSelecionado.getLinkGit());
  res.setLinkImage(projetoSelecionado.getLinkImage());

  repositoryProjetos.delete(projetoSelecionado);
  
  return ResponseEntity.ok(res);
 }
}
