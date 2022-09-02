package com.boss.analytics.model;

public abstract class AbstractPost {
    protected int foto;
    protected String nome;
    protected String desc;
    protected String idVideo;

    public AbstractPost(int foto, String nome, String desc, String idVideo) {
        this.foto = foto;
        this.nome = nome;
        this.desc = desc;
        this.idVideo = idVideo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }
}
