package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jordão
 */
public class SimulaEleicao {

    /**
     * Lista de Votos.
     */
    private List<Voto> votos;

    /**
     * Cria instância Simula Eleição.
     */
    public SimulaEleicao() {
        this.votos = new ArrayList<>();
    }

    /**
     * Incrementa votos no Candidato caso o voto seja válido.
     */
    public void contarVotos() {
        for (Voto voto : this.votos) {
            if (voto.eValido()) {
                voto.getCandidato().incrementarVotos();
            }
        }
    }
}
