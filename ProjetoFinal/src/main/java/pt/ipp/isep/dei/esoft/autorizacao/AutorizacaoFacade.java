package pt.ipp.isep.dei.esoft.autorizacao;

import pt.ipp.isep.dei.esoft.autorizacao.model.*;

/**
 * Autorizacao Facade.
 *
 * @author paulomaio
 */
public class AutorizacaoFacade {
    private final RegistoPapeisUtilizador m_oPapeis = new RegistoPapeisUtilizador();
    private final RegistoUtilizadores m_oUtilizadores = new RegistoUtilizadores();
    private SessaoUtilizador m_oSessao = null;

    /**
     * Regista o papel de um utilizador.
     *
     * @param strPapel papel
     * @return boolean
     */
    public boolean registaPapelUtilizador(String strPapel) {
        PapelUtilizador papel = this.m_oPapeis.novoPapelUtilizador(strPapel);
        return this.m_oPapeis.addPapel(papel);
    }

    /**
     * Regista utilizador com papeis.
     *
     * @param strNome     nome
     * @param strEmail    email
     * @param strPassword password
     * @param papeis      papeis
     * @return boolean
     */
    public boolean registaUtilizadorComPapeis(String strNome, String strEmail, String strPassword, String[] papeis) {
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome, strEmail, strPassword);
        for (String strPapel : papeis) {
            PapelUtilizador papel = this.m_oPapeis.procuraPapel(strPapel);
            utlz.addPapel(papel);
        }

        return this.m_oUtilizadores.addUtilizador(utlz);
    }

    /**
     * Verifica se existe utilizador.
     *
     * @param strId id
     * @return boolean
     */
    public boolean existeUtilizador(String strId) {
        return this.m_oUtilizadores.hasUtilizador(strId);
    }


    /**
     * Faz login na sessão do utilizador.
     *
     * @param strId  id
     * @param strPwd password
     * @return sessão utilizador
     */
    public SessaoUtilizador doLogin(String strId, String strPwd) {
        Utilizador utlz = this.m_oUtilizadores.procuraUtilizador(strId);
        if (utlz != null) {
            if (utlz.hasPassword(strPwd)) {
                this.m_oSessao = new SessaoUtilizador(utlz);
            }
        }
        return getSessaoAtual();
    }

    /**
     * Devolve a sessão atual.
     *
     * @return sessão atual
     */
    public SessaoUtilizador getSessaoAtual() {
        return this.m_oSessao;
    }

    /**
     * Faz logout.
     */
    public void doLogout() {
        if (this.m_oSessao != null)
            this.m_oSessao.doLogout();
        this.m_oSessao = null;
    }
}
