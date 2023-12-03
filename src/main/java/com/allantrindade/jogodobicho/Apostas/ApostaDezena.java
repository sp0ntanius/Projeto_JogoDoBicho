package com.allantrindade.jogodobicho.Apostas;
import java.util.List;
import com.allantrindade.jogodobicho.Jogo.Animal;
import com.allantrindade.jogodobicho.Padrões.ApostaVisitor;

public class ApostaDezena extends Aposta{
    public ApostaDezena(String jgdr, String modal, String dz, double vlr){
        setJogador(jgdr);
        setModalidade(modal);
        setDezena(dz);
        setValor(vlr);
    }

    @Override
    public boolean accept(ApostaVisitor visitor, List<String> sorteados){
        boolean result = visitor.visit(this, sorteados);
        return result;
    }

    @Override
    public double multiplicador(){
        if (getModalidade().equals("C")){
            double valorMultiplicado = getValor() * 60;
            return valorMultiplicado;
        }
        else {
            double valorMultiplicado = getValor() * (60/5);
            return valorMultiplicado;
        }
    }
}
