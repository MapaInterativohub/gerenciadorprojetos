package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage;

public class dtoConfigCarrocel {

    private String linkImagenCarrocel;
    private Boolean imagenAtivadaDesativada;

    public dtoConfigCarrocel() {

    }

    public dtoConfigCarrocel(String linkImagenCarrocel, Boolean imagenAtivadaDesativada) {
        this.linkImagenCarrocel = linkImagenCarrocel;
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }

    public String getLinkImagenCarrocel() {
        return linkImagenCarrocel;
    }

    public void setLinkImagenCarrocel(String linkImagenCarrocel) {
        this.linkImagenCarrocel = linkImagenCarrocel;
    }

    public Boolean getImagenAtivadaDesativada() {
        return imagenAtivadaDesativada;
    }

    public void setImagenAtivadaDesativada(Boolean imagenAtivadaDesativada) {
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }
}
