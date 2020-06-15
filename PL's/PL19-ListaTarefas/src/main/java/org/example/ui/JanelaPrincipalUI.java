package org.example.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.controller.AplicacaoController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JanelaPrincipalUI implements Initializable {

    private final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
    private final KeyCombination ctrlO = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    private final KeyCombination ctrlP = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);
    private AplicacaoController appController;
    private Stage novaTarefaStage;
    @FXML
    private ListView lstViewTarefas;

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

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

    public void mnuFicheiroShowing(Event event) {
    }

    public void mnuFicheiroGuardarTextoAction(ActionEvent actionEvent) {
    }

    public void mnuFicheiroGuardarBinarioAction(ActionEvent actionEvent) {
    }

    public void mnuFicheiroSairAction(ActionEvent actionEvent) {
    }

    public void mnuTarefaShowing(Event event) {

    }

    public void mnuTarefaAdicionarAction(ActionEvent actionEvent) {
        novaTarefaStage.show();
    }

    public void mnuTarefaRemoverShowing(Event event) {
    }

    public void mnuTarefaRemoverSeleccionadaAction(ActionEvent actionEvent) {
    }

    public void mnuTarefaRemoverTodasAction(ActionEvent actionEvent) {
        if (!appController.listaVazia()) {
            appController.eliminarTarefas();
            lstViewTarefas.setItems();
        } else {
            criarAlerta(Alert.AlertType.ERROR, "ERRO!!", "Nenhuma Tarefa para Apagar!").show();
        }
    }

    public void atualizaTextBoxListaTarefas() {
        lstViewTarefas.setText(appController.getListaTarefas());
    }

    public void options(KeyEvent keyEvent) {
        if (!appController.listaVazia()) {
            if (ctrlZ.match(keyEvent)) {
                appController.eliminarUltimaTarefa();
                atualizaTextBoxListaTarefas();
            }
            if (ctrlO.match(keyEvent)) {
                lstViewTarefas.setText(appController.getListaTarefas());
            }
            if (ctrlP.match(keyEvent)) {
                lstViewTarefas.setText(appController.getListaTarefasPorPrioridade());
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
