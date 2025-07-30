package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoConfigCarrocel;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCarrocel;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryCarrocel;


@RestController
@RequestMapping("/carrocel")
public class ControllersConfigCarrosel {

    @Autowired
    RepositoryCarrocel repositorioImagens;

    @PostMapping("/addimagen")
    public ResponseEntity<ClassCarrocel> PostImagens(@RequestBody ClassCarrocel dtoCarrocel){
         
        repositorioImagens.save(dtoCarrocel);

        return ResponseEntity.ok(dtoCarrocel);
    }
}
