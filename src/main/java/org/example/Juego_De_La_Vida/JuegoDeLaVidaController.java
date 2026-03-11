package org.example.Juego_De_La_Vida;

import Celdas.*;
import Reglas.*;
import Tableros.*;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class JuegoDeLaVidaController {
    @FXML
    private Button simularBoton, sigBoton, pararButton, velocidadButton;
    @FXML
    private Label labelVel, labelGen, labelEstable;
    @FXML
    private GridPane grilla;
    private Tablero tablero;
    private Regla regla;
    private Timeline timeline;
    private int velocidad = 500, generacion=0;
    //x1 = 500; x2 = 250; x4 = 125. x1->x2->x4->x1

    @FXML
    public void initialize() {
        try {
            //Aqui agregan reglas, o las quitan.
            //El orden de las reglas es importante, para que no se apliquen reglas antes que otras o no pisarlas
            //Regla Basica siempre al final
            regla = new ReglaCombinacion(List.of(
                            new ReglaEnfermedad(),
                            new ReglaLatente(),
                            new ReglaBasica())
            );
            tablero = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 3.txt", regla);
            dibujar();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
            return; //en caso que Tablero siga NULL volver/terminar
        }
    }
    public void dibujar() {
        grilla.getChildren().clear();
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int col = 0; col < tablero.getColumnas(); col++) {
                Pane celda = new Pane();
                String color;
                if (tablero.getCelda(fila, col) instanceof CeldaEnferma)
                    color = "green";
                else if (tablero.getCelda(fila, col) instanceof CeldaLatente)
                    color = "gray";
                else if (tablero.getCelda(fila, col).estaViva())
                    color = "white";
                else
                    color = "black";
                celda.setStyle("-fx-background-color: " + color + ";" +"-fx-border-color: black;");
                celda.setPrefSize(15, 15);
                grilla.add(celda, col, fila);
            }
        }
    }
    @FXML
    public void siguienteGeneracion(){
        boolean estable = tablero.sigGeneracion();
        generacion++;
        dibujar();
        labelGen.setText("Generacion: " + generacion);
        if (estable)
            labelEstable.setText("Tablero Estable");
    }
    @FXML
    public void simular(){
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING)
            return;
        timeline = new Timeline(
                new KeyFrame(Duration.millis(velocidad), e -> {
                    boolean estable = tablero.sigGeneracion();
                    generacion++;
                    dibujar();
                    labelGen.setText("Generacion: " + generacion);
                    if (estable) {
                        timeline.stop();
                        labelEstable.setText("Tablero Estable");
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    public void parar(){
        if (timeline != null)
            timeline.stop();
    }
    @FXML
    public void cambiarVelocidad(){
        if (velocidad == 500) velocidad = 250;
        else if (velocidad == 250) velocidad = 125;
        else velocidad = 500;
        labelVel.setText("Velocidad: "+velocidad+"ms");
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            simular();
        }
    }
}