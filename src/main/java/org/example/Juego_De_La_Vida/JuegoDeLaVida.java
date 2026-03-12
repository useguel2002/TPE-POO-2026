package org.example.Juego_De_La_Vida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Clase principal de la aplicación JavaFX.
 *
 * Se encarga de iniciar la interfaz gráfica cargando
 * el archivo FXML que define la vista del programa.
 *
 * NOTA: Se utilizó Screen Builder para crear la interfaz principal.
 * Se utilizo Inteligencia Artificial para crear el archivo CSS dark_theme por simple estetica
 */
public class JuegoDeLaVida extends Application {
    /**
     * Método que JavaFX ejecuta automáticamente al iniciar la aplicación.
     *
     * stage: ventana principal de la aplicación
     */
    @Override
    public void start(Stage stage) throws IOException {
        //Carga el archivo FXML que define la interfaz grafica
        FXMLLoader fxmlLoader = new FXMLLoader(
                JuegoDeLaVida.class.getResource("hello-view.fxml")
        );
        //Se crea la escena con el contenido del FXML
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        //Título de la ventana
        stage.setTitle("Juego de la Vida");
        //Se asigna la escena a la ventana
        stage.setScene(scene);
        //Muestra la ventana
        stage.show();
    }
    /**
     * Lanza la aplicación JavaFX.
     */
    public static void main(String[] args) {
        launch();
    }
}