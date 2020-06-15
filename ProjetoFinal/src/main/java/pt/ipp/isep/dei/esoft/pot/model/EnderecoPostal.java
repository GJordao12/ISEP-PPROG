package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Endereço postal.
 *
 * @author paulomaio
 */
public class EnderecoPostal {
    private String m_strLocal;
    private String m_strCodPostal;
    private String m_strLocalidade;


    /**
     * Instancia um novo Endereço postal.
     *
     * @param strLocal      local
     * @param strCodPostal  código postal
     * @param strLocalidade localidade
     */
    public EnderecoPostal(String strLocal, String strCodPostal, String strLocalidade) {
        if ((strLocal == null) || (strCodPostal == null) || (strLocalidade == null) ||
                (strLocal.isEmpty()) || (strCodPostal.isEmpty()) || (strLocalidade.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strLocal = strLocal;
        this.m_strCodPostal = strCodPostal;
        this.m_strLocalidade = strLocalidade;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hash(this.m_strLocal, this.m_strCodPostal, this.m_strLocalidade);
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
        EnderecoPostal obj = (EnderecoPostal) o;
        return (Objects.equals(m_strLocal, obj.m_strLocal) &&
                Objects.equals(m_strCodPostal, obj.m_strCodPostal) &&
                Objects.equals(m_strLocalidade, obj.m_strLocalidade));
    }

    /**
     * Devolve a descrição textual do Endereço Postal
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Local: %s , Código Postal: %s , Localidade: %s", this.m_strLocal, this.m_strCodPostal, this.m_strLocalidade);
    }
}
