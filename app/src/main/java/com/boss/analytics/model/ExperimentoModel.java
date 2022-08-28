package com.boss.analytics.model;

import android.widget.ImageButton;

public class ExperimentoModel {
    private String titulo;
    private String data;
    private int imgPhoto;
    private ImageButton imgMenu;

    public ExperimentoModel() {
    }

    public ExperimentoModel(String titulo, String data, int imgPhoto) {
        this.titulo = titulo;
        this.data = data;
        this.imgPhoto = imgPhoto;
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

    public int getImgPhoto() {
        return imgPhoto;
    }

    public void setImgPhoto(int imgPhoto) {
        this.imgPhoto = imgPhoto;
    }

    public ImageButton getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(ImageButton imgMenu) {
        this.imgMenu = imgMenu;
    }
}
