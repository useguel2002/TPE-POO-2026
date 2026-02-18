package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button simularBoton, sigBoton, pararButton, velocidadButton;
    @FXML
    private Label labelVel, labelGen;
    @FXML
    private GridPane grilla;
    private Tablero tablero;
    private Timeline timeline;
    private int velocidad = 500; //x1 = 500; x2 = 250; x4 = 125. x1->x2->x4->x1

    @FXML
    public void initialize() {
        try {
            tablero = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 3.txt");
            dibujar();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
            return; //en caso que Tablero siga NULL volver/terminar
        }
    }
    public void dibujar(){
        grilla.getChildren().clear();
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int col = 0; col < tablero.getColumnas(); col++) {
                Pane celda = new Pane();
                celda.setStyle("-fx-border-color: black;");
                if (tablero.getCelda(fila, col).estaViva()) {
                    celda.setStyle("-fx-background-color: black;");
                } else {
                    celda.setStyle("-fx-background-color: white;");
                }
                celda.setPrefSize(15, 15);
                grilla.add(celda, col, fila);
            }
        }
    }
    @FXML
    public void siguienteGeneracion(){
        boolean estable = tablero.sigGeneracion();
        dibujar();
        if (estable) {
            System.out.println("Tablero estable");
        }
    }
    @FXML
    public void simular(){
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING)
            return; //si ya esta corriendo no deberia volver a hacerlo.
                    // Duplica la velocidad y genera mensajes infinitos por consola
        timeline = new Timeline(
                new KeyFrame(Duration.millis(velocidad), e -> {
                    boolean estable = tablero.sigGeneracion();
                    dibujar();
                    if (estable) {
                        timeline.stop();
                        System.out.println("Tablero estable");
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    public void parar(){
        //Si no esta simulando automaticamente y se presiona Parar daba error
        //debido a que el timeline estaba en NULL
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING)
            timeline.stop();
    }
    @FXML
    public void cambiarVelocidad(){
        if(timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            velocidad = velocidad / 2;
            if (velocidad == 125 / 2) velocidad = 500;
            simular();
        }
    }
}