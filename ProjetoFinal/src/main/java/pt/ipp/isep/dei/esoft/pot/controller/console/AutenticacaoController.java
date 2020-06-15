package pt.ipp.isep.dei.esoft.pot.controller.console;

import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;

import java.util.List;

/**
 * Autenticação Controller.
 *
 * @author paulomaio
 */
public class AutenticacaoController {
    private AplicacaoPOT m_oApp;

    /**
     * Instancia um novo Controller de Autenticação.
     */
    public AutenticacaoController() {
        this.m_oApp = AplicacaoPOT.getInstance();
    }

    /**
     * Efetua login boolean.
     *
     * @param strId  id
     * @param strPwd password
     * @return boolean
     */
    public boolean doLogin(String strId, String strPwd) {
        return this.m_oApp.doLogin(strId, strPwd);
    }

    /**
     * Devolve os Papéis do utilizador.
     *
     * @return papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador() {
        if (this.m_oApp.getSessaoAtual().isLoggedIn()) {
            return this.m_oApp.getSessaoAtual().getPapeisUtilizador();
        }
        return null;
    }

    /**
     * Efetua logout.
     */
    public void doLogout() {
        this.m_oApp.doLogout();
    }
}
