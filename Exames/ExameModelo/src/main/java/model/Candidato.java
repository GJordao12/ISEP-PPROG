package model;

/**
 * @author Jordão
 */
public class Candidato {

    /**
     * Nome do Candidato.
     */
    private String nome;

    /**
     * Número de Votos do Candidato.
     */
    private int numVotos;

    /**
     * Cria uma instância de Candidato recebendo como parâmetro o Nome do Candidato.
     *
     * @param nome Nome do Candidato
     */
    public Candidato(String nome) {
        this.nome = nome;
        this.inicialiazarNumVotos();
    }

    /**
     * Incrementa os votos do Candidato.
     */
    public void incrementarVotos() {
        this.numVotos = this.numVotos++;
    }

    /**
     * Inicializa o número de votos do Candidato a 0.
     */
    public void inicialiazarNumVotos() {
        this.numVotos = 0;
    }

    /**
     * Devolve o Nome do Candidato.
     *
     * @return Nome do Candidato
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve o número de Votos do Candidato.
     *
     * @return número de Votos do Candidato
     */
    public int getNumVotos() {
        return this.numVotos;
    }

    /**
     * Modifica o número de votos do Candidato.
     *
     * @param numVotos número de votos do Candidato
     */
    public void setNumVotos(int numVotos) {
        this.numVotos = 0;
    }
}
