package org.example.tpe_poo_ulises_seguel;

import Logica.*;
import java.io.IOException;
import java.util.Scanner;

public class TestConsola {
    private static void imprimir(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero.getCelda(i,j) instanceof CeldaEnferma)
                    System.out.print("E ");
                else if (tablero.getCelda(i,j) instanceof CeldaLatente)
                    System.out.print("L ");
                else if (tablero.getCelda(i,j) instanceof CeldaVivaRiesgo)
                    System.out.print("R ");
                else if (tablero.getCelda(i,j).estaViva())
                    System.out.print("O ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static int setGeneracion(){
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Ingrese cantidad de generaciones (0 si quiere indefinido): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 0) {
                    return n;
                } else {
                    System.out.println("El número no puede ser negativo.");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                scanner.next(); //limpia entrad
            }
        }
    }
    private static void simular(Tablero tablero){
        int n = setGeneracion();
        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tablero);
        if (n==0){
            while (true) {
                boolean estable = tablero.sigGeneracion();
                System.out.println("Generación " + i + ":");
                imprimir(tablero);
                i++;
                if (estable) {
                    System.out.println("El tablero se volvió estable.");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            for (;i<=n;i++){
                boolean estable = tablero.sigGeneracion();
                System.out.println("Generación " + i + ":");
                imprimir(tablero);
                if (estable) {
                    System.out.println("El tablero se volvió estable. No cambiará ninguna de sus celdas.");
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Tablero tablero;
        try {
            tablero = TableroCarga.desdeArchivo("src/main/resources/Ejemplos/Ejemplo 5.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
            return; //en caso que TableroA siga NULL volver/terminar
        }
        Tablero tableroB = TableroCarga.aleatorio(10, 10, 0.5);
        simular(tablero);

    }

}