package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Jordão
 */
public class SceneController implements Initializable {

    private ArrayList<String> letras = new ArrayList<>();
    private ArrayList<String> letrasGuardadas = new ArrayList<>();

    @FXML
    private TextField quantidadeLetras;
    @FXML
    private Label letrasOrdenadas;

    @FXML
    private void confirmarAction() {

        addLetras();

        String letrasPrint = "";

        float qtdLetras = Float.parseFloat(quantidadeLetras.getText());
        if (qtdLetras >= 3 && qtdLetras <= 7) {
            try {
                if (qtdLetras != 3 && qtdLetras != 4 && qtdLetras != 5 && qtdLetras != 6 && qtdLetras != 7) {
                    throw new NumberFormatException();
                }
                letrasGuardadas.clear();
                for (int i = 0; i < qtdLetras; i++) {
                    letrasPrint = letrasPrint + "  " + letras.get(i);
                    letrasGuardadas.add(letras.get(i));
                }
                letrasOrdenadas.setText(letrasPrint);
            } catch (NumberFormatException nfe) {
                criarAlertaNaoInteiro().showAndWait();
            }
        } else {
            criarAlertaForaIntervalo().showAndWait();
        }
    }

    public Alert criarAlertaForaIntervalo() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Quantidade de Letras");
        alerta.setHeaderText("Valor Introduzido");
        alerta.setContentText("Deve ser introduzido um valor entre 3 e 7!");

        return alerta;
    }

    public Alert criarAlertaNaoInteiro() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Quantidade de Letras");
        alerta.setHeaderText("Valor Introduzido");
        alerta.setContentText("Deve ser introduzido um valor inteiro!");

        return alerta;
    }

    public void shiftEsquerdaAction() {

        String letrasPrint = "";

        ArrayList<String> letrasComShift = new ArrayList<>();

        String primeiraLetra = letrasGuardadas.get(0);
        for (int i = 0; i < letrasGuardadas.size() - 1; i++) {
            letrasComShift.add(letrasGuardadas.get(i + 1));
        }
        letrasComShift.add(primeiraLetra);

        letrasGuardadas = new ArrayList<>(letrasComShift);

        for (int i = 0; i < letrasGuardadas.size(); i++) {
            letrasPrint = letrasPrint + "  " + letrasGuardadas.get(i);
        }
        letrasOrdenadas.setText(letrasPrint);
    }

    public void shiftDireitaAction() {

        String letrasPrint = "";

        ArrayList<String> letrasComShift = new ArrayList<>();

        String ultimaLetra = letrasGuardadas.get(letrasGuardadas.size() - 1);
        letrasComShift.add(letrasGuardadas.get(0));

        for (int i = 0; i < letrasGuardadas.size() - 1; i++) {
            letrasComShift.add(letrasGuardadas.get(i));
        }
        letrasComShift.set(0, ultimaLetra);

        letrasGuardadas = new ArrayList<>(letrasComShift);

        for (int i = 0; i < letrasGuardadas.size(); i++) {
            letrasPrint = letrasPrint + "  " + letrasGuardadas.get(i);
        }

        letrasOrdenadas.setText(letrasPrint);
    }

    public void addLetras() {

        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        confirmarAction();
    }
}
