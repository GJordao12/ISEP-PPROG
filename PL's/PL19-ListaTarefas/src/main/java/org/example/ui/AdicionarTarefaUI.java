package org.example.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import org.example.controller.AplicacaoController;
import org.example.model.Prioridade;
import java.net.URL;
import java.util.ResourceBundle;

public class AdicionarTarefaUI implements Initializable {
    private JanelaPrincipalUI janelaPrincipalUI;

    @FXML
    private TextField txtTarefa;

    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cmbPrioridade.getSelectionModel().select(Prioridade.BAIXA);
        this.cmbPrioridade.getItems().setAll(Prioridade.values());
    }

    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoController();
            boolean adicionou = appController.adicionarTarefa(
                    this.txtTarefa.getText().trim(),
                    this.cmbPrioridade.getValue());
            if (adicionou) {
                janelaPrincipalUI.atualizaTextBoxListaTarefas();
            }

            criarAlerta(Alert.AlertType.INFORMATION, "Adição de nova Tarefa",
                    adicionou ? "Tarefa adicionada com sucesso"
                            : "Não foi possível adicionar a tarefa").show();

            encerrarNovaTarefaUI(event);
        } catch (IllegalArgumentException iae) {
            criarAlerta(Alert.AlertType.ERROR, "Erro nos dados!", iae.getMessage()).show();
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText("Confirmação da ação.");
        alerta.setContentText("Deseja mesmo cancelar?");

        ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
        ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");

        if (alerta.showAndWait().get() == ButtonType.CANCEL) {
            event.consume();
        }else{
            encerrarNovaTarefaUI(event);
        }
    }

    private void encerrarNovaTarefaUI(ActionEvent event) {
        this.txtTarefa.clear();
        this.cmbPrioridade.getSelectionModel().select(Prioridade.BAIXA);

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Nova Tarefa");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }
}

