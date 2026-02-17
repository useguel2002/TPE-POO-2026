package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button simularBoton, sigBoton, pararButton, velocidadButton;
    @FXML
    private Label labelVel;
    @FXML
    private GridPane grilla;
    private Tablero tablero;
    private Timeline timeline;
    @FXML
    public void initialize() {
        try {
            tablero = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 2.txt");
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
        timeline = new Timeline(
                new KeyFrame(Duration.millis(500), e -> {
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
}