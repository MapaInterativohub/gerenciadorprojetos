package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCursos;

public interface RepositoryCurso extends JpaRepository<ClassCursos,Long>{
    Optional<ClassCursos> findByCodigoDoCurso(String codigoDoCurso);
}
