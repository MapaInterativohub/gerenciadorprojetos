package com.example.API_Fabrica_Software.Enun;

import lombok.Getter;

@Getter
public enum NivelUsuario {

    ADMIN("admin"),
    USER("user");

    private final String descricao;

    NivelUsuario(String descricao) {
        this.descricao = descricao;
    }
}
