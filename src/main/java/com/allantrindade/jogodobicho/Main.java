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
        Jogador novoJogador = new Jogador(nome);
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
                    double valorObtido = vlr * jogada.multiplicador();
                    novoJogador.incrementarGanho(valorObtido);
                    novoJogador.incrementarApostas(jogada);

                    System.out.println("Parabéns! Você ganhou R$"+ valorObtido + " com esta aposta.");
                }
                else {
                    novoJogador.incrementarPerda(vlr);
                    novoJogador.incrementarApostas(jogada);
                    System.out.println("Infelizmente você perdeu...\nMais sorte na próxima vez!");
                }
            }

            else if (modal1.equals("D")){
                System.out.println("Informe a dezena que deseja apostar: ");
                String dezena = sc.nextLine().strip();
                
                System.out.println("Deseja apostar no 1º prêmio ou em todos os prêmios? (C - 1º prêmio / T - Todos os prêmios)");
                String modal2 = sc.nextLine().toUpperCase();

                System.out.println("Apostou em "+ jogo.getAnimal(dezena) + ".");
                
                System.out.println("Qual o valor da aposta?");
                double vlr = sc.nextDouble();

                ApostaDezena jogada = new ApostaDezena(jogo.getAnimal(dezena), modal2, dezena, vlr);
                System.out.println("Hora dos resultados!");

                // Sorteio
                List<String> sorteados = new ArrayList<>();
                List<String> dezenaSorteados = new ArrayList<>();
                sorteados = jogo.sortearMilhares();
                for (String milhar : sorteados){
                    String dezenaSorteada = milhar.substring(2, 4);
                    dezenaSorteados.add(dezenaSorteada);
                }
                // Lista de animais usados no print
                List<Animal> animalSorteado = new ArrayList<>();
                for (String dezenas : dezenaSorteados){
                    animalSorteado.add(jogo.getAnimal(dezenas));
                }
                // Utilização do Iterator para verificar se há prêmios repetidos
                while (true){
                    BichoIterator iterator = new BichoIterator(animalSorteado, sorteados.size());
                    if (iterator.temRepetidos()){
                        sorteados.clear();
                        animalSorteado.clear();
                        dezenaSorteados.clear();
                        sorteados.addAll(jogo.sortearMilhares());
                        
                        for (String milhar : sorteados){
                            String dezenaSorteada = milhar.substring(2, 4);
                            dezenaSorteados.add(dezenaSorteada);
                        }
                    
                        animalSorteado = new ArrayList<>();
                        for (String dezenas : dezenaSorteados){
                            animalSorteado.add(jogo.getAnimal(dezenas));
                        }
                    }

                    else break;
                }
                
                // Utilização do Visitor para comparação
                ApostaVisitor visitor = new VerificadorApostaVisitor();
                boolean resultado = jogada.accept(visitor, sorteados);

                // Print dos milhares sorteados e os animais que representam
                System.out.println("Os milhares sorteados foram:");
                for (int i = 0; i < 5; i++){
                    System.out.println(sorteados.get(i) + " (" + animalSorteado.get(i).getNome() + ")");
                }

                // Verificação da dezena apostada com os milhares sorteados
                if (resultado){
                    double valorObtido = vlr * jogada.multiplicador();
                    novoJogador.incrementarGanho(valorObtido);
                    novoJogador.incrementarApostas(jogada);

                    System.out.println("Parabéns! Você ganhou R$"+ valorObtido + " com esta aposta.");
                }
                else {
                    novoJogador.incrementarPerda(vlr);
                    novoJogador.incrementarApostas(jogada);
                    System.out.println("Infelizmente você perdeu...\nMais sorte na próxima vez!");
                }
            }

            else if (modal1.equals("C")) {
                System.out.println("Informe a centena que deseja apostar: ");
                String centena = sc.nextLine().strip();
                
                System.out.println("Deseja apostar no 1º prêmio ou em todos os prêmios? (C - 1º prêmio / T - Todos os prêmios)");
                String modal2 = sc.nextLine().toUpperCase();

                System.out.println("Apostou em "+ jogo.getAnimal(centena) + ".");
                
                System.out.println("Qual o valor da aposta?");
                double vlr = sc.nextDouble();

                ApostaCentena jogada = new ApostaCentena(jogo.getAnimal(centena), modal2, centena, vlr);
                System.out.println("Hora dos resultados!");

                // Sorteio 
                List<String> sorteados = new ArrayList<>();
                List<String> centenasSorteadas = new ArrayList<>();
                sorteados = jogo.sortearMilhares();
                for (String milhar : sorteados){
                    String centenaSorteada = milhar.substring(1, 4);
                    centenasSorteadas.add(centenaSorteada);
                }
                // Lista de animais usados no print
                List<Animal> animalSorteado = new ArrayList<>();
                for (String centenas : centenasSorteadas){
                    animalSorteado.add(jogo.getAnimal(centenas));
                }
                // Utilização do Iterator para verificar se há prêmios repetidos
                while (true){
                    BichoIterator iterator = new BichoIterator(animalSorteado, sorteados.size());
                    if (iterator.temRepetidos()){
                        sorteados.clear();
                        animalSorteado.clear();
                        centenasSorteadas.clear();
                        sorteados.addAll(jogo.sortearMilhares());
                        
                        for (String milhar : sorteados){
                            String centenaSorteada = milhar.substring(1, 4);
                            centenasSorteadas.add(centenaSorteada);
                        }
                    
                        animalSorteado = new ArrayList<>();
                        for (String centenas : centenasSorteadas){
                            animalSorteado.add(jogo.getAnimal(centenas));
                        }
                    }
                    else break;
                }
                // Utilização do Visitor para comparação
                ApostaVisitor visitor = new VerificadorApostaVisitor();
                boolean resultado = jogada.accept(visitor, sorteados);
                
                // Print dos milhares sorteados e os animais que representam
                System.out.println("Os milhares sorteados foram:");
                for (int i = 0; i < 5; i++){
                    System.out.println(sorteados.get(i) + " (" + animalSorteado.get(i).getNome() + ")");
                }
                
                // Verificação da centena apostada com os milhares sorteados
                if (resultado){
                    double valorObtido = vlr * jogada.multiplicador();
                    novoJogador.incrementarGanho(valorObtido);
                    novoJogador.incrementarApostas(jogada);

                    System.out.println("Parabéns! Você ganhou R$"+ valorObtido + " com esta aposta.");
                }
                else {
                    novoJogador.incrementarPerda(vlr);
                    novoJogador.incrementarApostas(jogada);
                    System.out.println("Infelizmente você perdeu...\nMais sorte na próxima vez!");
                }
            }
            
            else if (modal1.equals("M")){
                System.out.println("Informe o milhar que deseja apostar: ");
                String milhar = sc.nextLine().strip();
                
                System.out.println("Deseja apostar no 1º prêmio ou em todos os prêmios? (C - 1º prêmio / T - Todos os prêmios)");
                String modal2 = sc.nextLine().toUpperCase();

                System.out.println("Apostou em "+ jogo.getAnimal(milhar) + ".");
                
                System.out.println("Qual o valor da aposta?");
                double vlr = sc.nextDouble();

                ApostaMilhar jogada = new ApostaMilhar(jogo.getAnimal(milhar), modal2, milhar, vlr);
                System.out.println("Hora dos resultados!");
                
                // Sorteio 
                List<String> sorteados = new ArrayList<>();
                sorteados = jogo.sortearMilhares();

                // Lista de animais usados no print
                List<Animal> animalSorteado = new ArrayList<>();
                for (String milhares : sorteados){
                    animalSorteado.add(jogo.getAnimal(milhares));
                }
                
                // Utilização do Iterator para verificar se há prêmios repetidos
                while (true){
                    BichoIterator iterator = new BichoIterator(animalSorteado, sorteados.size());
                    if (iterator.temRepetidos()){
                        sorteados.clear();
                        sorteados.addAll(jogo.sortearMilhares());
                    }
                    else break;
                }
                
                // Utilização do Visitor para comparação
                ApostaVisitor visitor = new VerificadorApostaVisitor();
                boolean resultado = jogada.accept(visitor, sorteados);
                
                // Print dos milhares sorteados e os animais que representam
                System.out.println("Os milhares sorteados foram:");
                for (int i = 0; i < 5; i++){
                    System.out.println(sorteados.get(i) + " (" + animalSorteado.get(i).getNome() + ")");
                }

                // Verificação do milhar apostada com os milhares sorteados
                if (resultado){
                    double valorObtido = vlr * jogada.multiplicador();
                    novoJogador.incrementarGanho(valorObtido);
                    novoJogador.incrementarApostas(jogada);

                    System.out.println("Parabéns! Você ganhou R$"+ valorObtido + " com esta aposta.");
                }
                else {
                    novoJogador.incrementarPerda(vlr);
                    novoJogador.incrementarApostas(jogada);
                    System.out.println("Infelizmente você perdeu...\nMais sorte na próxima vez!");
                }

            }
            sc = new Scanner(System.in);
            
        }    
    }
}
