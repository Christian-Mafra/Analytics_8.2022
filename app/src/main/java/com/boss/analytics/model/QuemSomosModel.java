package com.boss.analytics.model;

public class QuemSomosModel {
    private int foto;
    private String textViewNomeQuemSomos;
    private String info1QuemSomos;
    private String info2QuemSomos;
    private String info3QuemSomos;
    private int cardViewQuemSomos;

    public QuemSomosModel() {
    }

    public QuemSomosModel(int foto, String textViewNomeQuemSomos, String info1QuemSomos, String info2QuemSomos, String info3QuemSomos, int cardViewQuemSomos) {
        this.foto = foto;
        this.textViewNomeQuemSomos = textViewNomeQuemSomos;
        this.info1QuemSomos = info1QuemSomos;
        this.info2QuemSomos = info2QuemSomos;
        this.info3QuemSomos = info3QuemSomos;
        this.cardViewQuemSomos = cardViewQuemSomos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTextViewNomeQuemSomos() {
        return textViewNomeQuemSomos;
    }

    public void setTextViewNomeQuemSomos(String textViewNomeQuemSomos) {
        this.textViewNomeQuemSomos = textViewNomeQuemSomos;
    }

    public String getInfo1QuemSomos() {
        return info1QuemSomos;
    }

    public void setInfo1QuemSomos(String info1QuemSomos) {
        this.info1QuemSomos = info1QuemSomos;
    }

    public String getInfo2QuemSomos() {
        return info2QuemSomos;
    }

    public void setInfo2QuemSomos(String info2QuemSomos) {
        this.info2QuemSomos = info2QuemSomos;
    }

    public String getInfo3QuemSomos() {
        return info3QuemSomos;
    }

    public void setInfo3QuemSomos(String info3QuemSomos) {
        this.info3QuemSomos = info3QuemSomos;
    }

    public int getCardViewQuemSomos() {
        return cardViewQuemSomos;
    }

    public void setCardViewQuemSomos(int cardViewQuemSomos) {
        this.cardViewQuemSomos = cardViewQuemSomos;
    }
}
