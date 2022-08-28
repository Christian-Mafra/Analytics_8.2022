package com.boss.analytics.model;

import com.boss.analytics.configFirebase.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class UsuarioModel {
    private String idUsuario;
    private String nome;
    private String email;
    private String senha;

    public UsuarioModel() {
    }

    public void salvar(){

        DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase();
        reference.child("usuarios")
                .child(this.getIdUsuario())
                .setValue(this);

    }

    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
