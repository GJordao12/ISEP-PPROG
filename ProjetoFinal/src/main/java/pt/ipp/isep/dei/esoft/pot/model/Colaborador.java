package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Colaborador.
 *
 * @author paulomaio
 */
public class Colaborador {
    private String m_strNome;
    private String m_strFuncao;
    private String m_strTelefone;
    private String m_strEmail;


    /**
     * Instancia um novo Colaborador.
     *
     * @param strNome     nome
     * @param strFuncao   função
     * @param strTelefone telefone
     * @param strEmail    email
     */
    public Colaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        if ((strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null) ||
                (strNome.isEmpty()) || (strFuncao.isEmpty()) || (strTelefone.isEmpty()) || (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strNome = strNome;
        this.m_strFuncao = strFuncao;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
    }

    /**
     * Tem id.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strEmail.equalsIgnoreCase(strId);
    }

    /**
     * Devolve o nome do colaborador.
     *
     * @return nome do colaborador
     */
    public String getNome() {
        return this.m_strNome;
    }

    /**
     * Devolve o email do colaborador.
     *
     * @return email do colaborador
     */
    public String getEmail() {
        return this.m_strEmail;
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
        Colaborador obj = (Colaborador) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
    }

    /**
     * Devolve a descrição textual do Colaborador.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Nome: %s , Função: %s , Telefone: %s , Email: %s", this.m_strNome, this.m_strFuncao, this.m_strTelefone, this.m_strEmail);
    }
}
