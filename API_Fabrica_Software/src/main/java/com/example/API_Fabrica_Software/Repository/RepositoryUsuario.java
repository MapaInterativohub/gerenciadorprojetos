package com.example.API_Fabrica_Software.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Fabrica_Software.Model.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{
 Optional<Usuario> existsByLogin(String login);
 Usuario findByLogin(String login);
}
