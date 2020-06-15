package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Menu Colaborador Organização UI.
 *
 * @author Jordão e António
 */
public class MenuColaboradorOrganizacaoUI {

    /**
     * Instancia um novo Menu Colaborador Organização UI.
     */
    public MenuColaboradorOrganizacaoUI() {
    }

    /**
     * Run.
     */
    public void run() {
        List<String> options = new ArrayList<>();
        options.add("Seriar Anúncio");

        int opcao;
        do {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Colaborador de Organização");

            switch (opcao) {
                case 0:
                    SeriarAnuncioUI uiSerAnun = new SeriarAnuncioUI();
                    uiSerAnun.run();
                    break;
            }
        }
        while (opcao != -1);
    }
}

