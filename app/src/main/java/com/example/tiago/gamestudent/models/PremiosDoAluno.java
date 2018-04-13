package com.example.tiago.gamestudent.models;

public class PremiosDoAluno {

    private int Id;
    private String nome;
    private int pontos_necessarios;


    public PremiosDoAluno() {
    }

    public PremiosDoAluno(int id, String nome, int pontos_necessarios) {
        Id = id;
        this.nome = nome;
        this.pontos_necessarios = pontos_necessarios;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos_necessarios() {
        return pontos_necessarios;
    }

    public void setPontos_necessarios(int pontos_necessarios) {
        this.pontos_necessarios = pontos_necessarios;
    }
}


