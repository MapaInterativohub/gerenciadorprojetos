package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.AlunosDTO.dtoAlunoAtulizarInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;
@Service
public class ServicePutProjetos {
 @Autowired
 RepositoryProjetos repositoryProjetos;

 public ResponseEntity<dtoProjetoAtulizacaoInfomacao> putProjeto(String identificador , dtoProjetoAtulizacaoInfomacao objDto){

  Optional<ClassProjetos> projeto = repositoryProjetos.findByCodigoProjeto(identificador);

  if(projeto.isEmpty()){
   System.out.println("Não tem");
   return ResponseEntity.badRequest().build();
  }

  dtoProjetoAtulizacaoInfomacao respostaDTO =  new dtoProjetoAtulizacaoInfomacao();
  return ResponseEntity.ok(respostaDTO);
 }
}
