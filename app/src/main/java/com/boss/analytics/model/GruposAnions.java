package com.boss.analytics.model;

public class GruposAnions {
    private String grupos, anions;
    private int imagem;

    public GruposAnions(String grupos, String anions, int imagem) {
        this.grupos = grupos;
        this.anions = anions;
        this.imagem = imagem;
    }


    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String getAnions() {
        return anions;
    }

    public void setAnions(String anions) {
        this.anions = anions;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImage(int imagem) {
        this.imagem = imagem;
    }

}
