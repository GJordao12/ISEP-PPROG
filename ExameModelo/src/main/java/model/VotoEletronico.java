package model;

/**
 * @author Jordão
 */
public class VotoEletronico extends Voto implements ValidaVotos {

    /**
     * Cria uma instância de Voto Eletrónico.
     *
     * @param candidato Candidato
     * @param data      Data de Voto
     * @param dataLim   Data Limite
     */
    public VotoEletronico(Candidato candidato, int data, int dataLim) {
        super(candidato, data, dataLim);
    }

    @Override
    public boolean eValido() {
        return this.VerificaData();
    }

    @Override
    public boolean VerificaData() {
        return !(super.getData() > super.getDataLim() - 2);
    }

    @Override
    public String toString() {
        if (this.eValido())
            return String.format("Voto eletrónico para %s -> válido", super.getCandidato().getNome());
        return String.format("Voto eletrónico para %s -> inválido", super.getCandidato().getNome());
    }
}
