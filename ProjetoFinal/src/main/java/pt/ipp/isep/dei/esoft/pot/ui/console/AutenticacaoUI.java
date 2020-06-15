package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.pot.controller.console.AutenticacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.util.List;

/**
 * Autenticação UI.
 *
 * @author paulomaio
 */
public class AutenticacaoUI {
    private AutenticacaoController m_controller;

    /**
     * Instancia um novo Autenticação UI.
     */
    public AutenticacaoUI() {
        m_controller = new AutenticacaoController();
    }

    /**
     * Run.
     *
     * @return boolean
     */
    public boolean run() {
        System.out.println("\nEfetuar Login/Autenticação:");

        int maxTentativas = 3;
        boolean sucesso;
        do {
            maxTentativas--;
            String sId = Utils.readLineFromConsole("Introduza Id/Email: ");
            String sPwd = Utils.readLineFromConsole("Introduza Palavra-Passe: ");

            sucesso = m_controller.doLogin(sId, sPwd);
            if (!sucesso) {
                System.out.println("Utilizador ou Palavra-Passe erradas. \n Possui mais " + maxTentativas + " tentativas");
            }

        } while (!sucesso && maxTentativas > 0);
        return sucesso;
    }

    /**
     * Devolve os papéis do utilizador.
     *
     * @return papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador() {
        return this.m_controller.getPapeisUtilizador();
    }

    /**
     * Efetuar Logout.
     */
    public void logout() {
        m_controller.doLogout();
    }
}
