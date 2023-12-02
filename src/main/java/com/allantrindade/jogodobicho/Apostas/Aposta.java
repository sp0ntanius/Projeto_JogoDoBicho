package com.allantrindade.jogodobicho.Apostas;

import java.util.ArrayList;
import java.util.List;

public abstract class Aposta {
    private String jogador;
    private String modalidade;
    private String grupo;
    private List<String> grupos = new ArrayList<>();
    private String dezena;
    private String centena;
    private String milhar;
    private double valor;

    public String getGrupo() {
        return grupo;
    }

    public double getValor() {
        return valor;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getDezena() {
        return dezena;
    }

    public List<String> getGrupos() {
        return grupos;
    }
    
    public String getCentena() {
        return centena;
    }

    public String getMilhar() {
        return milhar;
    }

    public String getJogador() {
        return jogador;
    }

    public void setCentena(String centena) {
        this.centena = centena;
    }

    public void setGrupos(List<String> grupos) {
        for (String grupo : grupos){
            this.grupos.add(grupo);
        }
    }

    public void setMilhar(String milhar) {
        this.milhar = milhar;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
    public void setDezena(String dezena) {
        this.dezena = dezena;
    }

    
    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    public abstract double multiplicador();
    
}