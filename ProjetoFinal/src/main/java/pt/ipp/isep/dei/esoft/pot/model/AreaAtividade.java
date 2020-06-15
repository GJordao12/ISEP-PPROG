package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Area Atividade.
 *
 * @author Jordão e António
 */
public class AreaAtividade {
    private String m_strCodigo;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;


    /**
     * Instancia uma nova Area de Atividade.
     *
     * @param strCodigo             código
     * @param strDescricaoBreve     descrição breve
     * @param strDescricaoDetalhada descrição detalhada
     */
    public AreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada) {
        if ((strCodigo == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (strCodigo.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strCodigo = strCodigo;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
    }

    /**
     * Verifica se o ID existe.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strCodigo.equalsIgnoreCase(strId);
    }

    /**
     * Devolve o código da Area de Atividade.
     *
     * @return código
     */
    public String getCodigo() {
        return this.m_strCodigo;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strCodigo);
        return hash;
    }

    /**
     * Verifica se dois objetos são iguais.
     *
     * @param o objeto
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        AreaAtividade obj = (AreaAtividade) o;
        return (Objects.equals(m_strCodigo, obj.m_strCodigo));
    }

    /**
     * Devolve a descrição textual da área de atividade.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Código: %s , Descrição Breve: %s , Descrição Detalhada: %s ", this.m_strCodigo, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada);
    }
}
