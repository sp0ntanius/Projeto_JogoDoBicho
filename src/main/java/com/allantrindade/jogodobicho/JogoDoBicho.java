package com.allantrindade.jogodobicho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JogoDoBicho {
    List<Animal> animais;
    List<List<String>> grupos;
    public JogoDoBicho() {
        animais = new ArrayList<>();
        grupos = new ArrayList<>();
        // Adicionando animais com seus grupos correspondentes
        List<String> bichos = new ArrayList<>();
        bichos.addAll(Arrays.asList("avestruz", "águia", "burro", "borboleta", "cachorro", "cabra",
                "carneiro", "camelo", "cobra", "coelho", "cavalo", "elefante", "galo", "gato", "jacaré",
                "leão", "macaco", "porco", "pavão", "peru", "touro", "tigre", "urso", "veado", "vaca"));
        
        grupos.addAll(Arrays.asList(
        Arrays.asList("01","02","03","04"),Arrays.asList("05", "06","07","08"),Arrays.asList("09", "10","11","12"),Arrays.asList("13", "14","15","16"),Arrays.asList("17", "18","19","20"),
        Arrays.asList("21", "22","23","24"),Arrays.asList("25", "26","27","28"),Arrays.asList("29", "30","31","32"),Arrays.asList("33", "34","35","36"),Arrays.asList("37", "38","39","40"),
        Arrays.asList("41", "42","43","44"),Arrays.asList("45", "46","47","48"),Arrays.asList("49", "50","51","52"),Arrays.asList("53", "54","55","56"),Arrays.asList("57", "58","59","60"),
        Arrays.asList("61", "62","63","64"),Arrays.asList("65", "66","67","68"),Arrays.asList("69", "70","71","72"),Arrays.asList("73", "74","75","76"),Arrays.asList("77", "78","79","80"),
        Arrays.asList("81", "82","83","84"),Arrays.asList("85", "86","87","88"),Arrays.asList("89", "90","91","92"),Arrays.asList("93", "94","95","96"),Arrays.asList("97", "98","99","00")));
        
        for (int i = 0; i < bichos.size() ; i++) {
            Animal bicho = new Animal(bichos.get(i), grupos.get(i));
            animais.add(bicho);
        }
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public Animal getAnimal(int index){
        return animais.get(index);
    }

    public List<Animal> sortearAnimais() {
        
        List<Animal> sorteados = new ArrayList<>();
        Random rd = new Random();
        
        for (int i = 0; i < 5; i++){
            int indiceSorteado = rd.nextInt(animais.size());
            Animal sorteado = getAnimal(indiceSorteado);
            sorteados.add(sorteado);
        }
        return sorteados;
    }

    /*
    Random rd = new Random();
        int indiceSorteado = rd.nextInt(animais.size());

        return animais.get(indiceSorteado);

    public Aposta realizarApostaDG(String jgdr, String modal, List<Integer> grps, double valor ){
      Aposta jogador = new Aposta(jgdr, modal, grps, valor);
      System.out.println("O jogador "+jgdr+" realizou a aposta na categoria "+modal+", nos grupos "+grps.toString()+", com o valor R$"+valor);
      return jogador;
    }

    public Aposta realizarApostaTG(String jgdr, String modal, List<Integer> grps, double valor){
      Aposta jogador = new Aposta(jgdr, modal, grps, valor);
      System.out.println("O jogador "+jgdr+" realizou a aposta na categoria "+modal+", nos grupos "+grps.toString()+", com o valor R$"+valor);
      return jogador;
    }
    */
}