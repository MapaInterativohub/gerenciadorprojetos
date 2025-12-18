package com.example.API_Fabrica_Software.Model.ClassConfigPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="db_imagensCurso")
public class ClassImageCursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoImagem;
    @Column(columnDefinition = "TEXT")
    private String linkImagemCurso;
    @Column(nullable = false, unique = true)
    private String altImagem;

    public ClassImageCursos(){

    }
    public ClassImageCursos(Long id, String codigoImagem, String linkImagemCurso, String altImagem) {
        this.id = id;
        this.codigoImagem = codigoImagem;
        this.linkImagemCurso = linkImagemCurso;
        this.altImagem = altImagem;
    }

    @PrePersist
    public void GeradorDeCodigoImgemCurso(){
        String prefixo = "IMG";
        int numero = (int) (Math.random() * 9000) + 1000;
        this.codigoImagem = prefixo + numero;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigoImagem() {
        return codigoImagem;
    }
    public void setCodigoImagem(String codigoImagem) {
        this.codigoImagem = codigoImagem;
    }
    public String getLinkImagemCurso() {
        return linkImagemCurso;
    }
    public void setLinkImagemCurso(String linkImagemCurso) {
        this.linkImagemCurso = linkImagemCurso;
    }
    public String getAltImagem() {
        return altImagem;
    }
    public void setAltImagem(String altImagem) {
        this.altImagem = altImagem;
    }


}
