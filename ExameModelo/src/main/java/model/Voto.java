package model;

/**
 * @author Jordão
 */
public abstract class Voto {

    /**
     * Candidato escolhido.
     */
    private Candidato candidato;

    /**
     * Data do Voto.
     */
    private int data;

    /**
     * A data limite do voto a partir da qual o voto não poderá ser considerado.
     */
    private int dataLim;


    /**
     * Cria uma instância de Voto recebendo como parâmetro o Candidato, a Data de Voto e a Data Limite.
     *
     * @param candidato Candidato
     * @param data      Data de Voto
     * @param dataLim   Data Limite
     */
    public Voto(Candidato candidato, int data, int dataLim) {
        this.candidato = candidato;
        this.data = data;
        this.dataLim = dataLim;
    }

    /**
     * Devolve o Candidato.
     *
     * @return Candidato
     */
    public Candidato getCandidato() {
        return this.candidato;
    }

    /**
     * Devolve a Data do Voto.
     *
     * @return Data do Voto
     */
    public int getData() {
        return this.data;
    }

    /**
     * Devolve a Data Limite.
     *
     * @return Data Limite
     */
    public int getDataLim() {
        return this.dataLim;
    }

    /**
     * Verifica se um Voto é válido.
     *
     * @return boolean
     */
    public abstract boolean eValido();

    @Override
    public String toString() {
        if (this.eValido()) return String.format("%s -> válido", this.candidato.getNome());
        return String.format("%s -> inválido", this.candidato.getNome());
    }
}
