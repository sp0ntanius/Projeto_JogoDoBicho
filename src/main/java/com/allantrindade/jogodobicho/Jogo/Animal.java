package com.allantrindade.jogodobicho.Jogo;

import java.util.ArrayList;
import java.util.List;
public class Animal {
    private String nome;
    private List<String> numero = new ArrayList<>();

    public Animal(String name, List<String> numeros){
        nome = name;
        
        for (String num : numeros){
            this.numero.add(num);    
        }
    }
    public String getNome() {
        return nome;
    }
    public List<String> getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getNumero() + ")";
    }
}