package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.Objects;

/**
 * Papel Utilizador.
 *
 * @author paulomaio
 */
public class PapelUtilizador {
    private final String m_strPapel;
    private final String m_strDescricao;

    /**
     * Instancia um novo Papel de um Utilizador.
     *
     * @param strPapel papel
     */
    public PapelUtilizador(String strPapel) {
        if ((strPapel == null) || (strPapel.isEmpty()))
            throw new IllegalArgumentException("O argumento não pode ser nulo ou vazio.");

        this.m_strPapel = strPapel;
        this.m_strDescricao = strPapel;
    }

    /**
     * Verifica se tem ID.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strPapel.equals(strId);
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strPapel);
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
        PapelUtilizador obj = (PapelUtilizador) o;
        return Objects.equals(m_strPapel, obj.m_strPapel);
    }

    /**
     * Devolve a descrição textual do Papel de um utilizador.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("%s - %s", this.m_strPapel, this.m_strDescricao);
    }
}
