package model;

/**
 * @author Jordão
 */
public class VotoPapel extends Voto {

    /**
     * Assinado?
     */
    public boolean assinado;

    /**
     * Cria uma instância de Voto Papel.
     *
     * @param candidato Candidato
     * @param data      Data de Voto
     * @param dataLim   Data Limite
     * @param assinado  Assinado?
     */
    public VotoPapel(Candidato candidato, int data, int dataLim, boolean assinado) {
        super(candidato, data, dataLim);
        this.assinado = assinado;
    }

    @Override
    public boolean eValido() {
        return assinado;
    }

    @Override
    public String toString() {
        if (this.eValido()) return String.format("Voto em papel para %s -> válido", super.getCandidato().getNome());
        return String.format("Voto em papel para %s -> inválido", super.getCandidato().getNome());
    }
}
