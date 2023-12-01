package com.allantrindade.jogodobicho;

import java.util.ArrayList;
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
            String modal1 = sc.nextLine().toUpperCase();
            
            if (modal1.equals("G")){
                System.out.println("Em qual grupo deseja apostar? (1 a 25)");
                int grp = sc.nextInt();
                
                System.out.println("Deseja apostar no 1º prêmio ou em todos os prêmios? (C - 1º prêmio / T - Todos os prêmios)");
                
                String modal2 = sc.nextLine().toUpperCase();
                
                System.out.println("Apostou em "+ jogo.getAnimal(grp - 1) +".");
                String grpString = Integer.toString(grp);
                
                System.out.println("Qual valor da aposta? R$");
                double vlr = sc.nextDouble();

                ApostaGrupo jogada = new ApostaGrupo(nome, modal2, grpString, vlr);
                System.out.println("Hora dos resultados!");

                // Sorteio
                List<Animal> sorteados = new ArrayList<>();
                sorteados = jogo.sortearAnimais();

                // Separação para comparação entre o animal apostado e o animal sorteado
                List<List<String>> gruposSorteados = new ArrayList<>();
                for (Animal gpsSorteados2 : sorteados){
                    gruposSorteados.add(gpsSorteados2.getNumero());

                }
                // Print dos animais sorteados e seus números
                System.out.println("Os animais sorteados foram:");
                for (Animal sorteados3 : sorteados){
                    System.out.println(sorteados3.getNome() + " " + sorteados3.getNumero());
                }
                // Verificação dos grupos sorteados com o grupo apostado
                for (List<String> grupoSorteados : gruposSorteados){

                    if (grupoSorteados.contains(jogada.getGrupo())){
                        System.out.println("Parabéns! Você ganhou R$"+jogada.getValor() * jogada.multiplicador());
                        break;
                    }
                    else {
                        System.out.println("Infelizmente você perdeu...\nTente novamente!");
                        break;
                    }
                    
                }
            }
            
            sc = new Scanner(System.in);
            
        }    
    }
}
