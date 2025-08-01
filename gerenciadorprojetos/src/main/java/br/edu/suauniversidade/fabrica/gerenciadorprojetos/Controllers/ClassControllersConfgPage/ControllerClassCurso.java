package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassCursoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassCursoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassImageCursoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassImageCursoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCursos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassImageCursos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryCurso;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryImagensCurso;


@RestController
@RequestMapping("/curso")
public class ControllerClassCurso {
    @Autowired
    RepositoryCurso repositoryCurso;

    @PostMapping("/curso")
    public ResponseEntity<dtoClassCursoResp> AddImagenCurso(@RequestBody dtoClassCursoPost dto){
        ClassCursos curso =  new ClassCursos();

        curso.setNomeDoCurso(dto.getNomeDoCurso());

        repositoryCurso.save(curso);

        dtoClassCursoResp dtoResposta = new dtoClassCursoResp();

        dtoResposta.setCodigoDoCurso(curso.getCodigoDoCurso());
        dtoResposta.setNomeDoCurso(curso.getNomeDoCurso());

        return ResponseEntity.ok(dtoResposta);
    }

    // @GetMapping("/curso")
    // public List<dtoClassImageCursoResp> GetImagens(){
    //     List<ClassImageCursos> dados = crepositoryImagensCurso.findAll();
    //     return dados.stream().map(dtoClassImageCursoResp::new).toList();
    // }

    // @GetMapping("/curso/{codigoDoCurso}")
    // public ResponseEntity<dtoClassImageCursoResp> GetImagen(@PathVariable String codigoDoCurso){
    //     Optional<ClassImageCursos> imagens = crepositoryImagensCurso.findByCodigoImagem(codigoImagem);
    //     if(imagens.isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }

    //     ClassImageCursos imagen = imagens.get();
    //     dtoClassImageCursoResp repostaDto =  new dtoClassImageCursoResp();

    //     repostaDto.setCodigoImagem(imagen.getCodigoImagem());
    //     repostaDto.setLinkImagemCurso(imagen.getLinkImagemCurso());
    //     repostaDto.setAltImagem(imagen.getAltImagem());

    //     return ResponseEntity.ok(repostaDto);
    // }
    // @DeleteMapping("/imagemcurso/{codigoDoCurso}")
    // public ResponseEntity<dtoClassImageCursoResp> DeletImagen(@PathVariable String codigoDoCurso){
    //     Optional<ClassImageCursos> itenSelecionado =  crepositoryImagensCurso.findByCodigoImagem(codigoImagem);

    //     if(itenSelecionado.isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }

    //     ClassImageCursos iten = itenSelecionado.get();

    //     crepositoryImagensCurso.delete(iten);

    //     dtoClassImageCursoResp itensDeletado = new dtoClassImageCursoResp();

    //     itensDeletado.setCodigoImagem(iten.getCodigoImagem());
    //     itensDeletado.setLinkImagemCurso(iten.getLinkImagemCurso());
    //     itensDeletado.setAltImagem(iten.getAltImagem());
    //     return ResponseEntity.ok(itensDeletado);
    // }
}
