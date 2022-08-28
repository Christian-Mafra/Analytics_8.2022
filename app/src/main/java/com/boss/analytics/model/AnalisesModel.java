package com.boss.analytics.model;

public class AnalisesModel {
    private String titulo, data;
    private int image;

    public AnalisesModel() {
    }

    public AnalisesModel(String titulo, String data, int image) {
        this.titulo = titulo;
        this.data = data;
        this.image = image;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
