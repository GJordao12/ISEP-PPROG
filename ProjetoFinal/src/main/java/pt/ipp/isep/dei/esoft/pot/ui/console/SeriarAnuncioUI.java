package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.controller.console.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.util.List;

/**
 * Seriar Anúncio UI.
 *
 * @author Jordão e António
 */
public class SeriarAnuncioUI {

    private SeriarAnuncioController m_controller;

    /**
     * Instancia um novo Seriar Anúncio UI
     */
    public SeriarAnuncioUI() {
        m_controller = new SeriarAnuncioController();
    }

    /**
     * Run.
     */
    public void run() {

        System.out.println("\nSeriar Anuncio:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaSeriacao()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        } else {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }

    /**
     * Introduz os dados.
     *
     * @return boolean
     */
    private boolean introduzDados() {


        List<Anuncio> LstAnun = m_controller.getAnunciosParaSeriarAutomaticos();

        if (LstAnun.isEmpty()) {
            System.out.println("ERRO: Lista de Anúncio vazias!");
            return false;
        } else {
            String AnuncioId;
            Anuncio anun = (Anuncio) Utils.apresentaESeleciona(LstAnun, "Selecione o Anúncio que pretende seriar:");
            if (anun != null) {
                AnuncioId = anun.getSrtId();
                List<Candidatura> lstCand = m_controller.getCandidaturas(AnuncioId);
                if (lstCand.isEmpty()) {
                    System.out.println("ERRO: Lista de Candidaturas Vazia!");
                    return false;
                } else {
                    for (int i = 0; i < m_controller.getListaOrdenada().size(); i++) {
                        System.out.println(m_controller.getListaOrdenada().get(i));
                    }
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * Apresenta os dados.
     */
    private void apresentaDados() {
        System.out.println("\nSeriação:\n" + m_controller.getSeriacaoString());
    }
}
