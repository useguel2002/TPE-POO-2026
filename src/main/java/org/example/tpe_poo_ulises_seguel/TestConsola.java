package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import java.io.IOException;

public class TestConsola {
    public static void main(String[] args) {
        Tablero tableroA = null;
        try {
            tableroA = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 3.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
            return; //en caso que TableroA siga NULL volver/terminar
        }
        Tablero tableroB = TableroCarga.aleatorio(10,10,0.5);

        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tableroA);
        while (!tableroA.sigGeneracion()) {
            System.out.println("Generación " + i + ":");
            imprimir(tableroA);
            i++;
        }
    }

    private static void imprimir(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero.getCelda(i, j).estaViva() ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}