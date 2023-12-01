package com.allantrindade.jogodobicho;
import java.util.*;

public class BichoIterator implements Iterator<String>{
    private List<String> animais;
    private int qtddAnimais;
    
    public BichoIterator(List<Animal> animais, int qtdd){
        
        for (Animal animal : animais){
            this.animais.add(animal.getNome());
        }

        qtddAnimais = qtdd;
    }

    public boolean temRepetidos(){
        Set<String> set = new HashSet<>(animais);
        return set.size() < animais.size();
    }

    @Override
    public boolean hasNext(){
        return animais.size() < qtddAnimais || temRepetidos();
    }

    @Override
    public String next() {
        while (hasNext()) {
            if (animais.size() < qtddAnimais) {
                
            }
        }
        
    }
}
