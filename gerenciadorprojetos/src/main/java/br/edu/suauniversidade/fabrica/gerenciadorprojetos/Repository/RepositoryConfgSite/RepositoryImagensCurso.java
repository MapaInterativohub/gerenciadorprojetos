package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassImageCursos;

@Repository
public interface RepositoryImagensCurso extends JpaRepository<ClassImageCursos,Long> {
    Optional<ClassImageCursos> findByCodigoImagem(String codigoImagem);
}
