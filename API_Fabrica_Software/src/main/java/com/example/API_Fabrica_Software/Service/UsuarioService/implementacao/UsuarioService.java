package com.example.API_Fabrica_Software.Service.UsuarioService.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.Model.ClassUsuario;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;
import com.example.API_Fabrica_Software.Service.UsuarioService.UsuarioServices;

@Service
public class UsuarioService implements UsuarioServices{
  @Autowired
  RepositoryUsuario repositoryUsuario;

  @Override
  public repostaUsuarioDTO salvar(criarUsuarioDTO usuario) {
    ClassUsuario user = new ClassUsuario(usuario.nome(),usuario.login(),usuario.senha(),usuario.roles());
    repositoryUsuario.save(user);
    return new repostaUsuarioDTO(user.getNome(),user.getLogin(), user.getRoles());
  }
}
