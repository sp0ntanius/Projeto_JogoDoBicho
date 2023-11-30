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
    /*
    @Override
    public List<String> registro() {
        List<String> historico = new ArrayList<>();
        historico.add("Nome: " + getJogador());
        historico.add("Valor da Aposta: " + getValor());
        historico.add("Modalidade: Aposta de grupo - " + getModalidade());
        return historico;
    }
    */
    
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