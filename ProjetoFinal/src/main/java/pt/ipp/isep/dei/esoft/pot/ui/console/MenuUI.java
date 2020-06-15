package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu UI
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class MenuUI {

    /**
     * Instancia um novo Menu UI.
     */
    public MenuUI() {
    }

    /**
     * Run.
     */
    public void run() {
        List<String> options = new ArrayList<>();
        options.add("Login / Autenticação");
        int opcao;
        do {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Principal");

            switch (opcao) {
                case 0:
                    AutenticacaoUI uiLogin = new AutenticacaoUI();
                    boolean sucesso = uiLogin.run();
                    if (sucesso) {
                        redirecionaParaUI(uiLogin.getPapeisUtilizador());
                    }
                    uiLogin.logout();
                    break;
            }
        }
        while (opcao != -1);
    }

    /**
     * Redireciona para os Menus.
     *
     * @param papeis papeis do utilizador
     */
    private void redirecionaParaUI(List<PapelUtilizador> papeis) {
        if (papeis == null) {
            System.out.println("O utilizador não tem atribuído nenhum papel/função.");
            return;
        }
        if (papeis.isEmpty()) {
            System.out.println("O utilizador não tem atribuído nenhum papel/função.");
            return;
        }
        PapelUtilizador papel = selecionaPapel(papeis);

        if (papel.hasId("COLABORADOR_ORGANIZACAO")) {
            MenuColaboradorOrganizacaoUI ui = new MenuColaboradorOrganizacaoUI();
            ui.run();
        }
    }

    /**
     * Seleciona papel.
     *
     * @param papeis papeis do utilizador
     * @return papeis do utilizador
     */
    private PapelUtilizador selecionaPapel(List<PapelUtilizador> papeis) {
        if (papeis.size() == 1)
            return papeis.get(0);
        else
            return (PapelUtilizador) Utils.apresentaESeleciona(papeis, "Escolha o papel que pretende assumir:");
    }
}
