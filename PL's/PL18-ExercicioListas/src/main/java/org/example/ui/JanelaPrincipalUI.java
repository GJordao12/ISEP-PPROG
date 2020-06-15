package org.example.ui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.controller.AplicacaoController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Jordão
 */
public class JanelaPrincipalUI implements Initializable {

    private final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
    private final KeyCombination ctrlO = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    private final KeyCombination ctrlP = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);
    private AplicacaoController appController;
    private Stage novaTarefaStage;
    @FXML
    private TextArea txtAreaTarefas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Nova Tarefa");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);

            appController = new AplicacaoController();
            atualizaTextBoxListaTarefas();

            AdicionarTarefaUI novaTarefaUI = loader.getController();
            novaTarefaUI.associarParentUI(this);

            novaTarefaStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                    alerta.setTitle("Aplicação");
                    alerta.setHeaderText("Confirmação da ação.");
                    alerta.setContentText("Deseja mesmo encerrar a aplicação?");

                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");

                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    }
                }
            });
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    public void atualizaTextBoxListaTarefas() {
        txtAreaTarefas.setText(appController.getListaTarefas());
    }

    @FXML
    public void adicionarTarefaAction() {
        novaTarefaStage.show();
    }

    @FXML
    public void limparTarefasAction() {
        if (!appController.listaVazia()) {
            appController.eliminarTarefas();
            txtAreaTarefas.setText("");
        } else {
            criarAlerta(Alert.AlertType.ERROR, "ERRO!!", "Nenhuma Tarefa para Apagar!").show();
        }
    }

    public void options(KeyEvent keyEvent) {
        if (!appController.listaVazia()) {
            if (ctrlZ.match(keyEvent)) {
                appController.eliminarUltimaTarefa();
                atualizaTextBoxListaTarefas();
            }
            if (ctrlO.match(keyEvent)) {
                txtAreaTarefas.setText(appController.getListaTarefas());
            }
            if (ctrlP.match(keyEvent)) {
                txtAreaTarefas.setText(appController.getListaTarefasPorPrioridade());
            }
        } else {
            criarAlerta(Alert.AlertType.ERROR, "ERRO!!", "Lista de Tarefas Vazia!").show();
        }
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }
}
