package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.List;

/**
 * Sessão Utilizador.
 *
 * @author paulomaio
 */
public class SessaoUtilizador {
    private Utilizador m_oUtilizador;

    /**
     * Instancia uma nova Sessão de um Utilizador.
     *
     * @param oUtilizador utilizador
     */
    public SessaoUtilizador(Utilizador oUtilizador) {
        if (oUtilizador == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.m_oUtilizador = oUtilizador;
    }

    /**
     * Fazer logout.
     */
    public void doLogout() {
        this.m_oUtilizador = null;
    }

    /**
     * Verifica se está logado.
     *
     * @return boolean
     */
    public boolean isLoggedIn() {
        return this.m_oUtilizador != null;
    }

    /**
     * Está logado com um determinado papel.
     *
     * @param strPapel papel
     * @return boolean
     */
    public boolean isLoggedInComPapel(String strPapel) {
        if (isLoggedIn()) {
            return this.m_oUtilizador.hasPapel(strPapel);
        }
        return false;
    }

    /**
     * Devolve o email de um utilizador.
     *
     * @return email utilizador
     */
    public String getEmailUtilizador() {
        if (isLoggedIn())
            return this.m_oUtilizador.getEmail();
        return null;
    }

    /**
     * Devolve os papeis de um utilizador.
     *
     * @return papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador() {
        return this.m_oUtilizador.getPapeis();
    }
}
