package com.allantrindade.jogodobicho.Jogo;

import java.util.ArrayList;

import com.allantrindade.jogodobicho.Apostas.Aposta;


public class Jogador {
    private String nome;
    private ArrayList<Aposta> apostas;
    private double ganhos = 0;
    private double perdas = 0;

    public Jogador(String name){
        nome = name;
        apostas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void incrementarGanho(double ganho){
        this.ganhos += ganho;
    }

    public void incrementarPerda(double perda){
        this.perdas += perda;
    }
    public void incrementarApostas(Aposta aposta){
        apostas.add(aposta);
    }
    public void mostrarGanhos(){
        System.out.println("Você já ganhou "+ ganhos + " jogando o jogo do bicho!");
    }

    public void mostrarPerdas(){
        System.out.println("Você já investiu "+ perdas + " no jogo do bicho!");
    }

}