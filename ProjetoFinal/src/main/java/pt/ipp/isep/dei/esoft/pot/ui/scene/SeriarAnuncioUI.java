package pt.ipp.isep.dei.esoft.pot.ui.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.scene.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Seriar Anúncio UI
 *
 * @author Jordão e António
 */

public class SeriarAnuncioUI implements Initializable {

    /**
     * Botão seriar.
     */
    @FXML
    public Button buttonSeriar;

    /**
     * Botão ver candidaturas.
     */
    @FXML
    public Button buttonVerCandidaturas;

    /**
     * Botão ver anuncios.
     */
    @FXML
    public Button buttonVerAnuncios;

    /**
     * Lista de Anúncios
     */
    @FXML
    public ListView<Object> lista;

    /**
     * Texto a apresentar
     */
    @FXML
    public Label text;

    /**
     * Seriar Anuncio Controller.
     */
    public SeriarAnuncioController appController;

    /**
     * Autenticação UI.
     */
    private AutenticacaoUI autenticacaoIU;

    /**
     * Inicializa.
     *
     * @param location  url
     * @param resources recursos
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appController = new SeriarAnuncioController();
        getBotoesDisable(true, false, true);
    }

    /**
     * Botão Seriar action.
     */
    @FXML
    public void SeriarAction() {
        if (lista.getSelectionModel().getSelectedItem() == null) {
            criarAlerta(Alert.AlertType.ERROR, "Erro...", "Por favor, selecione o anúncio que pretende seriar!").show();
        } else {
            Anuncio AnuncioSelecionado = (Anuncio) lista.getSelectionModel().getSelectedItem();
            if (appController.getListaOrdenada(AnuncioSelecionado).isEmpty()) {
                criarAlerta(Alert.AlertType.ERROR, "Erro...", "A lista de Candidaturas está vazia!").show();
            } else {
                lista.getItems().setAll(appController.getListaOrdenada(AnuncioSelecionado));
                text.setText("Candidaturas:");
                getBotoesDisable(true, false, true);
            }
        }
    }

    /**
     * Botão Ver candidaturas action.
     */
    @FXML
    public void verCandidaturasAction() {
        if (lista.getSelectionModel().getSelectedItem() == null) {
            criarAlerta(Alert.AlertType.ERROR, "Erro...", "Por favor, selecione o anúncio que pretende ver as candidaturas!").show();
        } else {
            Anuncio AnuncioSelecionado = (Anuncio) lista.getSelectionModel().getSelectedItem();
            if (appController.getCandidaturas(AnuncioSelecionado).isEmpty()) {
                criarAlerta(Alert.AlertType.ERROR, "Erro...", "A lista de Candidaturas está vazia!").show();
            } else {
                lista.getItems().setAll((appController.getCandidaturas(AnuncioSelecionado)));
                text.setText("Candidaturas:");
                getBotoesDisable(true, false, true);
            }
        }
    }

    /**
     * Botão Ver anúncios action.
     */
    @FXML
    public void verAnunciosAction() {
        if (appController.getAnuncios().isEmpty()) {
            criarAlerta(Alert.AlertType.ERROR, "Erro...", "A lista de Anúncios está vazia!").show();
        } else {
            lista.getItems().setAll(appController.getAnuncios());
            text.setText("Anúncios:");
            getBotoesDisable(false, true, false);
        }
    }

    /**
     * Cria Alerta.
     *
     * @param tipoAlerta tipo alerta
     * @param cabecalho  cabeçalho
     * @param mensagem   mensagem
     * @return alerta
     */
    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("                                                      T4J");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9HHeeBYer-D8uNhIAaDy21bPA5-EnzwSMaHdcIBGGMAD3xrOgkA&s%22)"));

        return alerta;
    }

    /**
     * Desativar os botões
     *
     * @param a boolean
     * @param b boolean
     * @param c boolean
     */
    private void getBotoesDisable(boolean a, boolean b, boolean c) {
        buttonSeriar.setDisable(a);
        buttonVerAnuncios.setDisable(b);
        buttonVerCandidaturas.setDisable(c);
    }

    /**
     * Limpar Lista e Reset aos Botões.
     */
    public void limparEReset() {
        lista.getItems().clear();
        text.setText("");
        getBotoesDisable(true, false, true);
    }

    /**
     * Ligação à outra UI.
     *
     * @param autenticacaoUI Autenticação UI
     */
    public void associarParentUI(AutenticacaoUI autenticacaoUI) {
        this.autenticacaoIU = autenticacaoUI;
    }
}
