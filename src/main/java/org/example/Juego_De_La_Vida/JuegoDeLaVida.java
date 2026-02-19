package org.example.Juego_De_La_Vida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class JuegoDeLaVida extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JuegoDeLaVida.class.
                getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        stage.setTitle("Juego de la Vida");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}