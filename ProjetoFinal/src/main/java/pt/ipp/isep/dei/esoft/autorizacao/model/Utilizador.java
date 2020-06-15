package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.*;

/**
 * Utilizador.
 *
 * @author paulomaio
 */
public class Utilizador {
    private final String m_strNome;
    private final String m_strEmail;
    private final String m_strPassword;
    private final Set<PapelUtilizador> m_lstPapeis = new HashSet<>();

    /**
     * Instancia um novo Utilizador.
     *
     * @param strNome     nome
     * @param strEmail    email
     * @param strPassword password
     */
    public Utilizador(String strNome, String strEmail, String strPassword) {

        if ((strNome == null) || (strEmail == null) || (strPassword == null) || (strNome.isEmpty()) || (strEmail.isEmpty()) || (strPassword.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos não pode ser nulo ou vazio.");

        this.m_strNome = strNome;
        this.m_strEmail = strEmail;
        this.m_strPassword = strPassword;

    }

    /**
     * Devolve o ID.
     *
     * @return id
     */
    public String getId() {
        return this.m_strEmail;
    }

    /**
     * Devolve o nome.
     *
     * @return nome
     */
    public String getNome() {
        return this.m_strNome;
    }

    /**
     * Devolve o email.
     *
     * @return email
     */
    public String getEmail() {
        return this.m_strEmail;
    }

    /**
     * Verifica se tem ID.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strEmail.equals(strId);
    }

    /**
     * Verifica se tem Password.
     *
     * @param strPwd password
     * @return boolean
     */
    public boolean hasPassword(String strPwd) {
        return this.m_strPassword.equals(strPwd);
    }

    /**
     * Adiciona um determinado papel.
     *
     * @param papel papel
     * @return boolean
     */
    public boolean addPapel(PapelUtilizador papel) {
        if (papel != null)
            return this.m_lstPapeis.add(papel);
        return false;
    }

    /**
     * Verifica se tem um determinado papel.
     *
     * @param strPapel papel
     * @return boolean
     */
    public boolean hasPapel(String strPapel) {
        for (PapelUtilizador papel : this.m_lstPapeis) {
            if (papel.hasId(strPapel))
                return true;
        }
        return false;
    }

    /**
     * Devolve os papéis.
     *
     * @return papeis
     */
    public List<PapelUtilizador> getPapeis() {
        List<PapelUtilizador> list = new ArrayList<>(this.m_lstPapeis);
        return list;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
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
        Utilizador obj = (Utilizador) o;
        return Objects.equals(m_strEmail, obj.m_strEmail);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.m_strNome, this.m_strEmail);
    }
}
