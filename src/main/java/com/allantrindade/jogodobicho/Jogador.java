package com.allantrindade.jogodobicho;

import java.util.ArrayList;


public class Jogador<A extends Aposta> {
    private String nome;
    private ArrayList<A> apostas;
    private int ganhos = 0;
    private int perdas = 0;

    public void incrementarGanho(int ganho){
        this.ganhos += ganho;
    }

    public void incrementarPerda(int perda){
        this.perdas += perda;
    }
    public void incrementarApostas(A aposta){
        apostas.add(aposta);
    }
    public void mostrarGanhos(){
        System.out.println("Você já ganhou "+ ganhos + " jogando o jogo do bicho!");
    }

    public void mostrarPerdas(){
        System.out.println("Você já investiu "+ perdas + " no jogo do bicho!");
    }

}