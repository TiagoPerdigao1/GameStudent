package com.example.tiago.gamestudent.models;

public class CompetenciasDoALuno {

    private int Id;
    private String descricao;
    private int pontos_acumular;

    public CompetenciasDoALuno() {
    }

    public CompetenciasDoALuno(int id, String descricao, int pontos_acumular) {
        Id = id;
        this.descricao = descricao;
        this.pontos_acumular = pontos_acumular;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontos_acumular() {
        return pontos_acumular;
    }

    public void setPontos_acumular(int pontos_acumular) {
        this.pontos_acumular = pontos_acumular;
    }
}
