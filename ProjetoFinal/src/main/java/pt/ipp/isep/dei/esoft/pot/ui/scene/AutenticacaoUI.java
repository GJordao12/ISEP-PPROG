package pt.ipp.isep.dei.esoft.pot.ui.scene;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.console.AutenticacaoController;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Autenticação UI
 *
 * @author Jordão e António
 */
public class AutenticacaoUI implements Initializable {

    private AutenticacaoController appController;//a consola e a interface gráfica partilham o mesmo controller.
    private Stage seriarAnuncioStage;
    private SeriarAnuncioUI ui;
    private int maxTentativas = 3;
    @FXML
    private TextField emailUtilizador;
    @FXML
    private PasswordField passUtilizador;

    /**
     * Inicializa.
     *
     * @param url url
     * @param rb  rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            appController = new AutenticacaoController();
            ui = new SeriarAnuncioUI();

            seriarAnuncioStage = new Stage();
            seriarAnuncioStage.initModality(Modality.APPLICATION_MODAL);

            seriarAnuncioStage.setTitle("Seriar Anúncio");
            seriarAnuncioStage.setResizable(false);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SeriarAnuncio.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            seriarAnuncioStage.setScene(scene);

            ui = loader.getController();
            ui.associarParentUI(this);

            seriarAnuncioStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = criarAlerta(Alert.AlertType.CONFIRMATION, "Confirmação da ação.", "Deseja mesmo voltar ao Entrar?");

                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");

                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    } else {
                        ui.limparEReset();
                        AplicacaoPOT.getInstance().doLogout();
                    }
                }
            });
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    /**
     * Botão Entrar action.
     */
    @FXML
    public void EntrarAction() {
        String email = emailUtilizador.getText();
        String pass = passUtilizador.getText();
        if (email == null || pass == null || email.isEmpty() || pass.isEmpty()) {
            criarAlerta(Alert.AlertType.ERROR, "Erro nos dados...", "Os campos email e password têm de ser preenchidos!").show();
        } else {
            boolean sucesso = appController.doLogin(email, pass);
            if (!sucesso) {
                if (maxTentativas == 0) {
                    maxTentativas = 3;
                }
                maxTentativas--;
                criarAlerta(Alert.AlertType.ERROR, "Erro nos dados...", "O email ou password estão incorretos!\nTem mais " + maxTentativas + " tentativas!").show();
                emailUtilizador.clear();
                passUtilizador.clear();
            } else {
                emailUtilizador.clear();
                passUtilizador.clear();
                redirecionaParaStage(appController.getPapeisUtilizador());
            }
        }
    }

    /**
     * Redireciona para os Stages.
     *
     * @param papeis papeis do utilizador
     */
    private void redirecionaParaStage(List<PapelUtilizador> papeis) {
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
            seriarAnuncioStage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9HHeeBYer-D8uNhIAaDy21bPA5-EnzwSMaHdcIBGGMAD3xrOgkA&s%22)"));
            seriarAnuncioStage.show();
        }
    }

    /**
     * Seleciona papel.
     *
     * @param papeis papeis do utilizador
     * @return papel do utilizador
     */
    private PapelUtilizador selecionaPapel(List<PapelUtilizador> papeis) {
        return papeis.get(0);
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("                                                    T4J");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9HHeeBYer-D8uNhIAaDy21bPA5-EnzwSMaHdcIBGGMAD3xrOgkA&s%22)"));

        return alerta;
    }
}
