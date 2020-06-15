package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Registo utilizadores.
 *
 * @author paulomaio
 */
public class RegistoUtilizadores {

    private Set<Utilizador> m_lstUtilizadores = new HashSet<>();

    /**
     * Novo utilizador.
     *
     * @param strNome     nome do utilizador
     * @param strEmail    email do utilizador
     * @param strPassword password do utilizador
     * @return utilizador
     */
    public Utilizador novoUtilizador(String strNome, String strEmail, String strPassword) {
        return new Utilizador(strNome, strEmail, strPassword);
    }

    /**
     * Adiciona utilizador à lista de utilizadores.
     *
     * @param utlz utilizador
     * @return boolean
     */
    public boolean addUtilizador(Utilizador utlz) {
        if (utlz != null)
            return this.m_lstUtilizadores.add(utlz);
        return false;
    }

    /**
     * Procura utilizador.
     *
     * @param strId id
     * @return utilizador
     */
    public Utilizador procuraUtilizador(String strId) {
        for (Utilizador utlz : this.m_lstUtilizadores) {
            if (utlz.hasId(strId))
                return utlz;
        }
        return null;
    }

    /**
     * Verifica se o utilizador existe.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasUtilizador(String strId) {
        Utilizador utlz = procuraUtilizador(strId);
        if (utlz != null)
            return this.m_lstUtilizadores.contains(utlz);
        return false;
    }
}
