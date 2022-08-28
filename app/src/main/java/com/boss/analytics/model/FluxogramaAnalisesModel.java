package com.boss.analytics.model;

public class FluxogramaAnalisesModel {
    private String passo, procedimento,radio1, radio2, radio3;
    private int imageInfo;

    public FluxogramaAnalisesModel() {
    }

    public FluxogramaAnalisesModel(String passo, String procedimento, String radio1, String radio2, String radio3, int imageInfo) {
        this.passo = passo;
        this.procedimento = procedimento;
        this.radio1 = radio1;
        this.radio2 = radio2;
        this.radio3 = radio3;
        this.imageInfo = imageInfo;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getRadio1() {
        return radio1;
    }

    public void setRadio1(String radio1) {
        this.radio1 = radio1;
    }

    public String getRadio2() {
        return radio2;
    }

    public void setRadio2(String radio2) {
        this.radio2 = radio2;
    }

    public String getRadio3() {
        return radio3;
    }

    public void setRadio3(String radio3) {
        this.radio3 = radio3;
    }

    public int getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(int imageInfo) {
        this.imageInfo = imageInfo;
    }
}
