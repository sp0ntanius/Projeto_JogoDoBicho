package com.allantrindade.jogodobicho.Padrões;

import java.util.List;
import com.allantrindade.jogodobicho.Apostas.ApostaCentena;
import com.allantrindade.jogodobicho.Apostas.ApostaDezena;
import com.allantrindade.jogodobicho.Apostas.ApostaGrupo;
import com.allantrindade.jogodobicho.Apostas.ApostaMilhar;

public interface ApostaVisitor {
    boolean visit(ApostaGrupo jogada, List<String> sorteados);
    boolean visit(ApostaDezena jogada, List<String> sorteados);
    boolean visit(ApostaCentena jogada, List<String> sorteados);
    boolean visit(ApostaMilhar jogada, List<String> sorteados);
}
