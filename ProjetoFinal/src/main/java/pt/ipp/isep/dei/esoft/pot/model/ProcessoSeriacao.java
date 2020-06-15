package pt.ipp.isep.dei.esoft.pot.model;

/**
 * Processo seriação.
 *
 * @author Jordão e António
 */
public class ProcessoSeriacao {

    private Regimento m_oTipoRegimento;
    private Colaborador m_oColaborador;

    /**
     * Instancia um novo Processo de Seriação.
     *
     * @param m_oTipoRegimento tipo regimento
     * @param m_oColaborador   colaborador
     */
    public ProcessoSeriacao(Regimento m_oTipoRegimento, Colaborador m_oColaborador) {
        if ((m_oTipoRegimento == null) || (m_oColaborador == null))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_oTipoRegimento = m_oTipoRegimento;
        this.m_oColaborador = m_oColaborador;
    }

    /**
     * Devolve a descrição textual do processo de seriação.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("TipoRegimento: %s , Colaborador: %s", this.m_oTipoRegimento, this.m_oColaborador);
    }
}
