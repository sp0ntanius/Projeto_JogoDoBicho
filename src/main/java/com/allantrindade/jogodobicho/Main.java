package com.allantrindade.jogodobicho;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDoBicho jogo = new JogoDoBicho();
        System.out.println("Bem vindo ao jogo do bicho!\nInsira seu nome: ");
        String nome = sc.nextLine();
        while (true) {
        System.out.println("Olá "+nome+", sua aposta será em qual modalidade?\n(G - Grupo, D - Dezena, C - Centena, M - Milhar,\nDG - Duque de grupo, TG - Terno de grupo,\n" +
                "DD - Duque de Dezena, TD - Terno de Dezena): ");
        String modal = sc.nextLine().toUpperCase();

        if (modal.equals("G")){
            System.out.println("Em qual grupo deseja apostar? (1 a 25)");
            int grp = sc.nextInt();
            System.out.println("Apostou em "+ jogo.getAnimal(grp - 1) +".");
            System.out.println("Qual valor da aposta? R$");
            double vlr = sc.nextDouble();

            Aposta jogador = jogo.realizarApostaG(nome, modal, grp, vlr);
            System.out.println("Hora dos resultados!");

            // Sorteio
            Animal sorteado = jogo.sortearAnimal();
            System.out.println("O animal sorteado foi: "+sorteado.getNome() + " " + sorteado.getNumero());
           if (jogador.getGrupo() == sorteado.getNumero()){
               System.out.println("Parabéns! Você ganhou R$"+jogador.getValor() * jogador.multiplicador(jogador.getModalidade()) + ".");
           }
           else {
               System.out.println("Infelizmente você perdeu...\nTente novamente!");
           }
        }

        sc = new Scanner(System.in);
      }    
    }
}