package com.example.API_Fabrica_Software.Enun;

import lombok.Getter;

@Getter
public enum NivelUsuario {

    ADMIN("Autorização para todas as funcionalidades"),
    NIVEL_1("Pode criar, editar e deletar projetos e funcionalidades, além de alterar o site, sem acesso aos usuários"),
    NIVEL_2("Pode criar, editar e deletar projetos, sem alterar o site e sem acesso aos usuários");

    private final String descricao;

    NivelUsuario(String descricao) {
        this.descricao = descricao;
    }
}
