package com.boss.analytics.model;

public class GruposCations {
    private String cations;
    private int imagem;

    public GruposCations() {
    }

    public GruposCations(String cations, int imagem) {
        this.cations = cations;
        this.imagem = imagem;
    }

    public String getCations() {
        return cations;
    }

    public void setCations(String cations) {
        this.cations = cations;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
