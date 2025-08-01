package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_cursos")
public class ClassCursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true,nullable = false)
    private String codigoDoCurso;

    @Column(unique = true,nullable = false)
    private String nomeDoCurso;

    public ClassCursos(){

    }
    public ClassCursos(Long id, String codigoDoCurso, String nomeDoCurso) {
        this.id = id;
        this.codigoDoCurso = codigoDoCurso;
        this.nomeDoCurso = nomeDoCurso;
    }

    @PrePersist
    public void GeraCodigoCurso(){
        String prefixo = "CURS";
        int numero = (int) (Math.random() * 9000) + 1000;
        this.codigoDoCurso = prefixo + numero;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigoDoCurso() {
        return codigoDoCurso;
    }
    public void setCodigoDoCurso(String codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }
    public String getNomeDoCurso() {
        return nomeDoCurso;
    }
    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }
}
