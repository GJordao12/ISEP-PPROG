package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Grau de Proficiência.
 *
 * @author Jordão e António
 */
public class GrauProficiencia {

    private Integer m_intValor;
    private String m_strDesignacao;
    private List<GrauProficiencia> m_lstGrausProficiencia;

    /**
     * Instancia um novo Grau de Proficiência.
     *
     * @param m_intValor      valor
     * @param m_strDesignacao designação
     */
    public GrauProficiencia(Integer m_intValor, String m_strDesignacao) {
        if ((m_intValor == null) || (m_strDesignacao == null) || (m_strDesignacao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_intValor = m_intValor;
        this.m_strDesignacao = m_strDesignacao;

        this.m_lstGrausProficiencia = new ArrayList<>();
    }

    /**
     * Devolve o valor do Grau de Proficiência.
     *
     * @return valor valor do Grau de Proficiência
     */
    public Integer getM_intValor() {
        return this.m_intValor;
    }

    /**
     * Devolve a descrição textual do Grau de Proficiência
     *
     * @return descrição textual
     */
    public String toString() {
        return String.format("%d , %s", this.m_intValor, this.m_strDesignacao);
    }
}
