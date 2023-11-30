package com.allantrindade.jogodobicho;

import java.util.List;

abstract class Aposta {
    private String jogador;
    private String modalidade;
    private int grupo;
    private List<Integer> grupos;
    private String dezena;
    private String centena;
    private String milhar;
    private double valor;

    public int getGrupo() {
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

    public List<Integer> getGrupos() {
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

    public void setGrupos(List<Integer> grupos) {
        this.grupos = grupos;
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

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
/*
    public Aposta(String jog, String modal, String dz, double vlr){
        jogador = jog;
        modalidade = modal;
        dezena = dz;
        valor = vlr;
    }
    public Aposta(String jog, String modal, int grp, double vlr){
        jogador = jog;
        modalidade = modal;
        grupo = grp;
        valor = vlr;
    }
    public Aposta(String jog, String modal, List<Integer> grps, double vlr){
      jogador = jog;
      modalidade = modal;
      grupos.addAll(grps);
      valor = vlr;
    };
*/  
    public abstract void Aposta(String jgdr, String modal, List<Integer> grps, double valor);
    
    public abstract int multiplicador(int valor, int mult);
    
    
    

}