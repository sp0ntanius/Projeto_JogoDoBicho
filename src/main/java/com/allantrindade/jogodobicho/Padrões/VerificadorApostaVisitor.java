package com.allantrindade.jogodobicho.Padrões;
import com.allantrindade.jogodobicho.Apostas.*;
import java.util.*;




public class VerificadorApostaVisitor implements ApostaVisitor{
    @Override
    public boolean visit(ApostaGrupo jogada, List<String> sorteados){
        for (String grupo : sorteados){
            if (jogada.getAnimalApostado().getGrupo().equals(grupo)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean visit(ApostaDezena jogada, List<String> sorteados){
        
        for (String numero : sorteados){
            if (numero.endsWith(jogada.getDezena())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean visit(ApostaCentena jogada, List<String> sorteados){
        
        for (String numero : sorteados){
            if (numero.endsWith(jogada.getCentena())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean visit(ApostaMilhar jogada, List<String> sorteados){
       
        for (String numero : sorteados){
            if (numero.equals(jogada.getMilhar())) {
                return true;
            }
        }
        return false;
    }
}
