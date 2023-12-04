package com.allantrindade.jogodobicho.Jogo;

public class Regras {
    public void regrasGerais(){
        System.out.println("O Jogo do Bicho é um jogo de apostas onde você seleciona uma das opções de apostas e informa ao bicheiro qual deseja apostar.");
        System.out.println("O bicheiro leva sua aposta para o sorteio e aguarda o resultado, o qual tem 5 categorias, sendo que cada uma tem um número de 4 dígitos*.");
        System.out.println("Após o sorteio é apurado o resultado do Jogo do Bicho e a premiação é distribuída de acordo com as apostas dos vencedores.");
        System.out.println("Para apostar, você precisa escolher entre:");
        System.out.println("Animal(grupo)          Duque(dois animais)");
        System.out.println("Dezena                 Terno(três animais)");
        System.out.println("Centena");
        System.out.println("Milhar");
        System.out.println("\n*Para a aposta de grupo, o resultado dos sorteios aparecerá apenas os animais, não os milhares sorteados.");
    }
    public void regrasApostas(){
        System.out.println();
    }
}
