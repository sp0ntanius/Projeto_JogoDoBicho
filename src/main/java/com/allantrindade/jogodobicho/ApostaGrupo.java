package com.allantrindade.jogodobicho;

import java.util.ArrayList;
import java.util.List;


public class ApostaGrupo extends Aposta {

    public ApostaGrupo(String jgdr, String modal, String grp, double valor) {
        setJogador(jgdr);
        setModalidade(modal);
        setGrupo(grp);
        setValor(valor);
    }
   
    
    @Override
    public double multiplicador() {
        if (getModalidade().equals("C")){
            double valorMultiplicado = getValor() * 18;
            return valorMultiplicado;
        }
        else {
            double valorMultiplicado = getValor() * (18/5);
            return valorMultiplicado;
        }
    
    }
    
}