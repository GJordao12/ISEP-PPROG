package main.java.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Jordão
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/App.fxml"));
        primaryStage.setTitle("Contador de Cliques");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();
    }
}
