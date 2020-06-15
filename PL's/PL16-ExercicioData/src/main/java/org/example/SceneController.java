package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Jordão
 */
public class SceneController implements Initializable {

    @FXML
    private TextField txtData;
    @FXML
    private TextField txtDiaDaSemana;
    @FXML
    private TextField txtDataExtenso;

    @FXML
    private void DiaSemanaAction(ActionEvent event) {
        try {
            String[] ano_mes_dia = (txtData.getText().split("/"));
            if (ano_mes_dia.length != 3) {
                throw new NumberFormatException();
            }
            Data data = new Data(Integer.parseInt(ano_mes_dia[0]), Integer.parseInt(ano_mes_dia[1]), Integer.parseInt(ano_mes_dia[2]));
            txtDiaDaSemana.setText(data.diaDaSemana());
        } catch (NumberFormatException fie) {
            criarAlertaInvalida(txtData).showAndWait();
            apagarDados();
        } catch (MesInvalidoException mie) {
            criarAlertaMes(mie).showAndWait();
            apagarDados();
        } catch (DiaInvalidoException die) {
            criarAlertaDia(die).showAndWait();
            apagarDados();
        }
    }

    @FXML
    private void DataExtensoAction(ActionEvent event) {
        try {
            String[] ano_mes_dia = (txtData.getText().split("/"));
            if (ano_mes_dia.length != 3) {
                throw new NumberFormatException();
            }
            Data data = new Data(Integer.parseInt(ano_mes_dia[0]), Integer.parseInt(ano_mes_dia[1]), Integer.parseInt(ano_mes_dia[2]));
            txtDataExtenso.setText(data.toString());
        } catch (NumberFormatException fie) {
            criarAlertaInvalida(txtData).showAndWait();
            apagarDados();
        } catch (MesInvalidoException mie) {
            criarAlertaMes(mie).showAndWait();
            apagarDados();
        } catch (DiaInvalidoException die) {
            criarAlertaDia(die).showAndWait();
            apagarDados();
        }
    }

    @FXML
    private void LimparDadosAction(ActionEvent event) {
        txtData.setText("");
        txtDiaDaSemana.setText("");
        txtDataExtenso.setText("");
    }

    public Alert criarAlertaInvalida(TextField txtData) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Erro");
        alerta.setHeaderText("Data " + txtData.getText() + " é inválida!!!");

        return alerta;
    }

    public Alert criarAlertaMes(MesInvalidoException mie) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Erro");
        alerta.setHeaderText(mie.getMessage());

        return alerta;
    }

    public Alert criarAlertaDia(DiaInvalidoException die) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Erro");
        alerta.setHeaderText(die.getMessage());

        return alerta;
    }

    public void apagarDados() {
        txtDiaDaSemana.setText("");
        txtDataExtenso.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

