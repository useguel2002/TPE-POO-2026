package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import java.io.IOException;

public class TestConsola {
    public static void main(String[] args) {
        try {
            Tablero tableroA = TableroCarga.desdeArchivo("ejemplo.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }

        Tablero tableroB = TableroCarga.aleatorio(10,10,0.5);
        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tableroB);
        while (!tableroB.sigGeneracion()){
            System.out.println("Generación " + i + ":");
            imprimir(tableroB);
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