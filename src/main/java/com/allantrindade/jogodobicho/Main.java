package com.allantrindade.jogodobicho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.allantrindade.jogodobicho.Apostas.*;
import com.allantrindade.jogodobicho.Jogo.*;
import com.allantrindade.jogodobicho.Padrões.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDoBicho jogo = new JogoDoBicho();

        System.out.println("Bem vindo ao jogo do bicho!\nInsira seu nome: ");
        String nome = sc.nextLine();
        Jogador novoJogador = new Jogador<>(nome);
        while (true) {
            System.out.println("Olá "+novoJogador.getNome()+", sua aposta será em qual modalidade?\n(G - Grupo, D - Dezena, C - Centena, M - Milhar,\nDG - Duque de grupo, TG - Terno de grupo,\n" +
                    "DD - Duque de Dezena, TD - Terno de Dezena): ");
            String modal1 = sc.nextLine().toUpperCase();
            
            if (modal1.equals("G")){
                System.out.println("Em qual grupo deseja apostar? (1 a 25)");
                int grp = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Deseja apostar no 1º prêmio ou em todos os prêmios? (C - 1º prêmio / T - Todos os prêmios)");
                
                String modal2 = sc.nextLine().toUpperCase();
                
                System.out.println("Apostou em "+ jogo.getAnimal(grp - 1) +".");
                String grpString = Integer.toString(grp);
                
                System.out.println("Qual valor da aposta? R$");
                double vlr = sc.nextDouble();

                ApostaGrupo jogada = new ApostaGrupo(jogo.getAnimal(grp - 1), modal2, grpString, vlr);
                System.out.println("Hora dos resultados!");

                // Sorteio
                List<Animal> sorteados = new ArrayList<>();
                sorteados = jogo.sortearAnimais();
                // Utilização do Iterator para verificar se há prêmios repetidos
                while (true){
                    BichoIterator iterator = new BichoIterator(sorteados, sorteados.size());
                    if (iterator.temRepetidos()){
                        sorteados.clear();
                        sorteados.addAll(jogo.sortearAnimais());
                    }

                    else break;
                }
                    
                // Separação para comparação entre o animal apostado e o animal sorteado
                List<String> gruposSorteados = new ArrayList<>();
                
                for (Animal animais : sorteados){
                    gruposSorteados.add(animais.getGrupo());
                }

                // Utilização do Visitor para comparação
                ApostaVisitor visitor = new VerificadorApostaVisitor();
                boolean resultado = jogada.accept(visitor, gruposSorteados);

                // Print dos animais sorteados e seus números
                System.out.println("Os animais sorteados foram:");
                for (Animal sorteados3 : sorteados){
                    System.out.println(sorteados3.getNome() + " " + sorteados3.getNumeros());
                }

                // Verificação dos grupos sorteados com o grupo apostado
                if (resultado){
                    System.out.println("Parabéns!");
                }
                else System.out.println("Infelizmente você perdeu...");
            }
            
            sc = new Scanner(System.in);
            
        }    
    }
}
