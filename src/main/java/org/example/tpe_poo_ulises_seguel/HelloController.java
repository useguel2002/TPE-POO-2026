package org.example.tpe_poo_ulises_seguel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private GridPane tablero;
    private final int FILAS = 50;
    private final int COLUMNAS = 50;

    @FXML
    public void initialize() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                Pane celda = new Pane();
                celda.setStyle("-fx-border-color: black;");
                celda.setPrefSize(30, 30);

                tablero.add(celda, col, fila);
            }
        }
    }
}