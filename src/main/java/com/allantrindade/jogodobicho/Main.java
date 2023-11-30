package com.allantrindade.jogodobicho;

import java.util.List;
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
            String grpString = Integer.toString(grp);
            System.out.println("Qual valor da aposta? R$");
            double vlr = sc.nextDouble();

            ApostaGrupo jogada = new ApostaGrupo(nome, modal, grpString, vlr);
            System.out.println("Hora dos resultados!");

            // Sorteio
            Animal sorteado = jogo.sortearAnimal();
            List<String> grupoSorteado = sorteado.getNumero();
            System.out.println("O animal sorteado foi: "+sorteado.getNome() + " " + sorteado.getNumero());
           if (grupoSorteado.contains(jogada.getGrupo())){
               System.out.println("Parabéns! Você ganhou R$"+jogada.getValor() * jogada.multiplicador());
               break;
           }
           else {
               System.out.println("Infelizmente você perdeu...\nTente novamente!");
               break;
           }
           
        }
        /*
        sc = new Scanner(System.in);
        */
      }    
    }
}
