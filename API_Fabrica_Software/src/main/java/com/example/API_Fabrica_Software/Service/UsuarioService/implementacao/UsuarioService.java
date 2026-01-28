package com.example.API_Fabrica_Software.Service.UsuarioService.implementacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.Model.ClassUsuario;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;
import com.example.API_Fabrica_Software.Service.UsuarioService.UsuarioServices;

@Service
public class UsuarioService implements UsuarioServices {
  @Autowired
  RepositoryUsuario repositoryUsuario;
  @Autowired
  PasswordEncoder encoder;

  @Override
  public repostaUsuarioDTO salvar(criarUsuarioDTO usuario) {

    var senhaCriptografada = encoder.encode(usuario.senha());
    ClassUsuario user = new ClassUsuario(usuario.nome(), usuario.login(), senhaCriptografada, usuario.roles());

    repositoryUsuario.save(user);
    return new repostaUsuarioDTO(
        user.getId(),
        user.getNome(),
        user.getLogin(),
        user.getRoles(),
        user.getDataDeCriacao(),
        user.getDataDeAtulizacao());
  }

  @Override
  public List<repostaUsuarioDTO> usuarios() {
    List<ClassUsuario> users = repositoryUsuario.findAll();
    return users.stream().map(
        user -> new repostaUsuarioDTO(
            user.getId(),
            user.getNome(),
            user.getLogin(),
            user.getRoles(),
            user.getDataDeCriacao(),
            user.getDataDeAtulizacao()))
        .toList();
  }

  @Override
  public repostaUsuarioDTO getUser(Long id) {
    Optional<ClassUsuario> user = repositoryUsuario.findById(id);

    if (!user.isPresent()) {
      return null;
    }

    ClassUsuario u = user.get();
    return new repostaUsuarioDTO(
        u.getId(),
        u.getNome(),
        u.getLogin(),
        u.getRoles(),
        u.getDataDeCriacao(),
        u.getDataDeAtulizacao());
  }
}
