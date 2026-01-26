package com.example.API_Fabrica_Software.Service.UsuarioService;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;

public interface UsuarioServices {
 public repostaUsuarioDTO salvar(criarUsuarioDTO usuario);
}
