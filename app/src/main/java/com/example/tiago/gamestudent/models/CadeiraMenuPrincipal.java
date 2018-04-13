package com.example.tiago.gamestudent.models;

public class CadeiraMenuPrincipal {

    private int Id;
    private String nome;
    private int pontos;

    public CadeiraMenuPrincipal() {
    }

    public CadeiraMenuPrincipal(int id, String nome, int pontos) {
        Id = id;
        this.nome = nome;
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setCadeira(String nome) {
        this.nome = nome;
    }

}
