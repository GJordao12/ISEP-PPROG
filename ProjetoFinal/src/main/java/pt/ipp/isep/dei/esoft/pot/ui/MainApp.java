package pt.ipp.isep.dei.esoft.pot.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pt.ipp.isep.dei.esoft.leitura.StartLeituraFicheiros;
import pt.ipp.isep.dei.esoft.pot.ui.console.MenuUI;

import java.io.IOException;

/**
 * MainApp.
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */

public class MainApp extends Application {


    public static void main(String[] args) {

        try {
            StartLeituraFicheiros uiStarLeitura = new StartLeituraFicheiros();
            MenuUI uiMenu = new MenuUI();

            uiStarLeitura.run();
            //uiMenu.run(); //dar run pela consola!
            launch(args); //dar run pela interface gráfica!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage.setTitle("                                                                                       Entrar T4J");
            stage.setScene(scene);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                    alerta.setTitle("                                                    T4J");
                    alerta.setHeaderText("Confirmação da ação de encerramento...");
                    alerta.setContentText("Deseja mesmo encerrar a aplicação?");
                    getIcon(alerta);

                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
                    ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");

                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    }
                }
            });
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9HHeeBYer-D8uNhIAaDy21bPA5-EnzwSMaHdcIBGGMAD3xrOgkA&s%22)"));
            stage.show();
        } catch (IOException ex) {
            criarAlertaErro(ex).show();
        }
    }

    private Alert criarAlertaErro(Exception ex) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("                                                    T4J");
        alerta.setHeaderText("Problemas no arranque da aplicação");
        alerta.setContentText(ex.getMessage());
        getIcon(alerta);

        return alerta;
    }

    private void getIcon(Alert alerta) {
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9HHeeBYer-D8uNhIAaDy21bPA5-EnzwSMaHdcIBGGMAD3xrOgkA&s%22)"));
    }
}


