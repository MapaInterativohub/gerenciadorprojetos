package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

@Service
public class ServicePutProjetos {
  @Autowired
  RepositoryProjetos repositoryProjetos;

  @Autowired
  RepositoryAlunos repositoryAlunos;

  public ResponseEntity<dtoProjetoAtulizacaoInfomacao> putProjeto(String identificador,
      dtoProjetoAtulizacaoInfomacao objDto) {

    Optional<ClassProjetos> projeto = repositoryProjetos.findByCodigoProjeto(identificador);

    if (projeto.isEmpty()) {
      System.out.println("Class Não existe");
      return ResponseEntity.badRequest().build();
    }

    if (objDto.getAlunosParticipantesDoProjeto() != null) {
      ClassProjetos apagarLista = projeto.get();
      apagarLista.getAlunosParticipantesDoProjeto().clear();

      for (String ra : objDto.getAlunosParticipantesDoProjeto()) {
        // Verifica se Aluno existe
        Optional<ClassAlunos> alunoExiste = repositoryAlunos.findByRa(ra);
        if (alunoExiste.isPresent()) {
          ClassAlunos projetoAluno = alunoExiste.get();
          projetoAluno.setProjetoSelecionado(apagarLista);
          repositoryAlunos.save(projetoAluno);

          System.out.println(ra + " existe");
          System.out.println(projetoAluno.getProjetoSelecionado() + " agora tem "+ projetoAluno.getRa());
        } else {
          System.out.println(ra + " não existe");
        }
      }
    } else {
      System.out.println("Erro na Verificação de alunos");
      return ResponseEntity.badRequest().build();
    }

    dtoProjetoAtulizacaoInfomacao respostaDTO = new dtoProjetoAtulizacaoInfomacao();

    respostaDTO.setNomeDoProjeto(objDto.getNomeDoProjeto());
    respostaDTO.setAlunosParticipantesDoProjeto(objDto.getAlunosParticipantesDoProjeto());

    return ResponseEntity.ok(respostaDTO);
  }
}
