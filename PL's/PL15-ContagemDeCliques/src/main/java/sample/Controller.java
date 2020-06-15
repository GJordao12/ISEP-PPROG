package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author Jordão
 */
public class Controller {

    @FXML
    public Label label_lb1;
    private Contador c = new Contador();

    public void pressButton() {
        label_lb1.setText("Número de Cliques: " + c.addClique());
    }
}
