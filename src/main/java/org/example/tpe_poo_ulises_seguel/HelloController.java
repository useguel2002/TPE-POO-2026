package org.example.tpe_poo_ulises_seguel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    private Label label2;
    @FXML
    private Button bReset;
    @FXML
    private Button bOK;
    @FXML
    private Button bCancel;
    @FXML
    private Label label1;
    @FXML
    private Button boton1;
    int contadorOK = 0;
    int contadorCancel = 0;

    public void pushbutton(ActionEvent actionEvent) {
        label1.setText("Ha pulsado el botón");
        //compruebo qué objeto botón ha sido pulsado
        //ok o cancel para contarlo
        Object obj = actionEvent.getSource();
        if (obj == bOK) {
            contadorOK++;
            label1.setText("Ha pulsado OK " + contadorOK + " veces");
        }
        if (obj == bCancel) {
            contadorCancel++;
            label1.setText("Ha pulsado Cancel " + contadorCancel + " veces");
        }
        if (obj == bReset) {
            label1.setText("Label1");
            label2.setText("Tecla");
            contadorOK = 0;
            contadorCancel = 0;
        }
    }
    public void teclaPulsada(KeyEvent ke) {
        KeyCode key = ke.getCode();
        if (key == KeyCode.ENTER)
            label2.setText("ENTER");
        if (key == KeyCode.ESCAPE)
            label2.setText("ESCAPE");
    }
}