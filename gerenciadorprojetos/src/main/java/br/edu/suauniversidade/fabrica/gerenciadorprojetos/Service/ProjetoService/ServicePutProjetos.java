package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

@Service
public class ServicePutProjetos {
  @Autowired
  RepositoryProjetos repositoryProjetos;

  @Autowired
  RepositoryAlunos repositoryAlunos;

  @Autowired
  RepositoryGestores repositoryGestores;

  public ResponseEntity<dtoProjetoAtulizacaoInfomacao> putProjeto(String identificador,
      dtoProjetoAtulizacaoInfomacao objDto) {

    Optional<ClassProjetos> projeto = repositoryProjetos.findByCodigoProjeto(identificador);

    ClassProjetos listaAlunosEgestores = projeto.get();

    List<String> raS = new ArrayList<>();
    List<String> codigosGestores = new ArrayList<>();

    if (objDto.getAlunosParticipantesDoProjeto() != null) {
      // Apaga o projeto existente na entidade aluno para inserir um novo
      for (ClassAlunos projetoDoAluno : listaAlunosEgestores.getAlunosParticipantesDoProjeto()) {
        projetoDoAluno.setProjetoSelecionado(null);
        repositoryAlunos.save(projetoDoAluno);
      }

      for (String ra : objDto.getAlunosParticipantesDoProjeto()) {
        Optional<ClassAlunos> alunoExiste = repositoryAlunos.findByRa(ra);

        if (alunoExiste.isPresent()) {
          ClassAlunos projetoAluno = alunoExiste.get();
          projetoAluno.setProjetoSelecionado(listaAlunosEgestores);
          repositoryAlunos.save(projetoAluno);
          raS.add(projetoAluno.getRa());
        } else {
          return ResponseEntity.badRequest().build();
        }
      }
    }

    if (objDto.getProfesorOrientador() != null) {
      // Apaga o projeto existente na entidade aluno para inserir um novo
      for (ClassGestores projetoDoGestor : listaAlunosEgestores.getProfesorOrientador()) {
        projetoDoGestor.setProjetos(null);
        repositoryGestores.save(projetoDoGestor);
      }

      for (String Gestor : objDto.getProfesorOrientador()) {
        Optional<ClassGestores> gestorExistente = repositoryGestores.findByCodigoGestor(Gestor);

        if (gestorExistente.isPresent()) {
          ClassGestores projetoGestor = gestorExistente.get();
          projetoGestor.setProjetos(projetoGestor.getProjetos());
          repositoryGestores.save(projetoGestor);
          codigosGestores.add(projetoGestor.getCodigoGestor());
        } else {
          return ResponseEntity.badRequest().build();
        }
      }
    }else{
      return ResponseEntity.badRequest().build();
    }

    dtoProjetoAtulizacaoInfomacao respostaDTO = new dtoProjetoAtulizacaoInfomacao();

    respostaDTO.setNomeDoProjeto(objDto.getNomeDoProjeto());
    respostaDTO.setDescricaoDoProjeto(objDto.getDescricaoDoProjeto());
    respostaDTO.setAreaDeConhecimento(objDto.getAreaDeConhecimento());
    respostaDTO.setDataDeInicioDoProjeto(objDto.getDataDeInicioDoProjeto());
    respostaDTO.setDataDoFimDoProjeto(objDto.getDataDoFimDoProjeto());
    respostaDTO.setAlunosParticipantesDoProjeto(raS);
    respostaDTO.setProfesorOrientador(codigosGestores);
    respostaDTO.setLinkGit(objDto.getLinkGit());
    respostaDTO.setLinkImage(objDto.getLinkImage());
    return ResponseEntity.ok(respostaDTO);
  }
}
