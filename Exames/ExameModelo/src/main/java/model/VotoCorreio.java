package model;

/**
 * @author Jordão
 */
public class VotoCorreio extends Voto implements ValidaVotos {

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
    public VotoCorreio(Candidato candidato, int data, int dataLim, boolean assinado) {
        super(candidato, data, dataLim);
        this.assinado = assinado;
    }

    @Override
    public boolean VerificaData() {
        return (super.getData() <= super.getDataLim());
    }

    @Override
    public boolean eValido() {
        return (!this.assinado || this.VerificaData());
    }

    @Override
    public String toString() {
        if (this.eValido())
            return String.format("Envio de voto em papel para %s -> válido", super.getCandidato().getNome());
        return String.format("Envio de voto em papel para %s -> inválido", super.getCandidato().getNome());
    }
}
