package org.example.tpe_poo_ulises_seguel;

import Logica.*;

public class TestConsola {
    public static void main(String[] args) {
        Tablero tablero = TableroCarga.aleatorio(10,10,0.5);
        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tablero);
        while (!tablero.sigGeneracion()){
            System.out.println("Generación " + i + ":");
            imprimir(tablero);
            i++;
        }
    }

    private static void imprimir(Tablero tablero) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(tablero.getCelda(i, j).estaViva() ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}