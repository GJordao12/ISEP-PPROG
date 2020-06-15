package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;

/**
 * Regimento.
 *
 * @author Jordão e António
 */
public abstract class Regimento {

    private String m_strDesignacao;
    private String m_strDescricaoRegras;

    /**
     * Instancia um novo Regimento.
     *
     * @param m_strDesignacao      designação
     * @param m_strDescricaoRegras descrição regras
     */
    public Regimento(String m_strDesignacao, String m_strDescricaoRegras) {
        if ((m_strDesignacao == null) || (m_strDescricaoRegras == null) || (m_strDesignacao.isEmpty()) || (m_strDescricaoRegras.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        this.m_strDesignacao = m_strDesignacao;
        this.m_strDescricaoRegras = m_strDescricaoRegras;
    }

    /**
     * Devolve a designação do regimento.
     *
     * @return designação do regimento
     */
    public String getM_strDesignacao() {
        return this.m_strDesignacao;
    }

    /**
     * Devolve a descrição textual do Regimento.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Designação: %s , Descrição Regras: %s", this.m_strDesignacao, this.m_strDescricaoRegras);
    }

    /**
     * Seriar lista de candidaturas.
     *
     * @param anun anuncio
     * @return lista de candidaturas ordenada
     */
    public abstract List<Candidatura> Seriar(Anuncio anun);
}
