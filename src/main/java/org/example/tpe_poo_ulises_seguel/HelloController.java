package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HelloController {
    @FXML
    private GridPane grilla;
    @FXML
    private Tablero tablero;
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
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int col = 0; col < tablero.getColumnas(); col++) {
                Pane celda = new Pane();
                celda.setStyle("-fx-border-color: black;");
                if (tablero.getCelda(fila, col).estaViva()) {
                    celda.setStyle("-fx-background-color: black;");
                } else {
                    celda.setStyle("-fx-background-color: white;");
                }
                celda.setPrefSize(20, 20);
                grilla.add(celda, col, fila);
            }
        }
    }
    @FXML
    public void siguienteGeneracion(){
        tablero.sigGeneracion();
        dibujar();
    }
}