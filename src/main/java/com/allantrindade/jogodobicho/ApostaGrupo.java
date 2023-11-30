package com.allantrindade.jogodobicho;

import java.util.List;


abstract class ApostaGrupo extends Aposta{
    
    @Override
    public void Aposta(String jgdr, String modal, List<Integer> grps, double valor){
        ApostaGrupo jogador = new Aposta(jgdr, modal, grps, valor);
        
    }
   

}
