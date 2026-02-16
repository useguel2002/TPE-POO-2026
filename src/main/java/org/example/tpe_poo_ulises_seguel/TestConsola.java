package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import java.io.IOException;
import java.util.Scanner;

public class TestConsola {
    public static void main(String[] args) {
        Tablero tableroA;
        try {
            tableroA = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 3.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
            return; //en caso que TableroA siga NULL volver/terminar
        }
        Tablero tableroB = TableroCarga.aleatorio(10, 10, 0.5);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese cantidad de generaciones (0 si quiere indefinido): ");
        int n = scanner.nextInt();

        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tableroA);
        if (n==0){
            while (!tableroA.sigGeneracion()){
                System.out.println("Generación " + i + ":");
                imprimir(tableroA);
                i++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            do {
                System.out.println("Generación " + i + ":");
                imprimir(tableroA);
                i++;
            } while (!tableroA.sigGeneracion() && (i<=n));
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