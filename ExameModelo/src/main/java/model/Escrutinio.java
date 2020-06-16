package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jordão
 */
public class Escrutinio {

    /**
     * Conjunto de todos os candidatos a líder.
     */
    private List<Candidato> candidatos;

    /**
     * Número máximo de eleitores.
     */
    private int numEleitores;

    /**
     * Número de votantes.
     */
    private int numVot;

    /**
     * A data (dia) da eleição (um inteiro para simplificar).
     */
    private int data;

    /**
     * Cria instância de Escrutinio recebendo como parâmetro o Número de Eleitores e a Data.
     *
     * @param numEleitores Número de Eleitores
     * @param data         Data
     */
    public Escrutinio(int numEleitores, int data) {
        this.candidatos = new ArrayList<Candidato>();
        this.numEleitores = numEleitores;
        this.numVot = 0;
        this.data = data;
    }

    /**
     * Calcula o número de Votantes.
     */
    public void calcularVotantes() {
        for (Candidato cand : this.candidatos) {
            this.numVot = this.numVot + cand.getNumVotos();
        }
    }

    /**
     * Inicializa os Votos dos Candidatos a 0.
     */
    public void inicializarVotosCandidatos() {
        for (Candidato cand : this.candidatos) {
            cand.setNumVotos(0);
        }
    }

    /**
     * Retorna o(s) Candidato(s) com mais votos.
     *
     * @return Lista com vencedor(es)
     */
    public List<Candidato> vencedor() {
        this.candidatos.sort(Comparator.comparingDouble(Candidato::getNumVotos));
        List<Candidato> listMaisVotados = new ArrayList<>();
        listMaisVotados.add(this.candidatos.get(0));
        for (int i = 1; i < this.candidatos.size(); i++) {
            if (this.candidatos.get(i).getNumVotos() == this.candidatos.get(0).getNumVotos()) {
                listMaisVotados.add(this.candidatos.get(i));
            } else {
                break;
            }
        }
        return listMaisVotados;
    }
}
