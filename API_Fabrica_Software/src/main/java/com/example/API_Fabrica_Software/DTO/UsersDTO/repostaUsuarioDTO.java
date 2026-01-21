package com.example.API_Fabrica_Software.DTO.UsersDTO;

import com.example.API_Fabrica_Software.Enun.NivelUsuario;
import com.example.API_Fabrica_Software.Model.Usuario;

public record repostaUsuarioDTO(String usuario, String email, NivelUsuario role) {

 public repostaUsuarioDTO(Usuario u) {
  this(u.getNome(),u.getLogin(), u.getRoles());
 }

}
