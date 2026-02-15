package org.example.tpe_poo_ulises_seguel;

import Logica.*;

public class TestConsola {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(10, 10);
        // Patrón Blinker (oscilador)
        tablero.setCelda(0, 1, new CeldaViva());
        tablero.setCelda(1, 2, new CeldaViva());
        tablero.setCelda(2, 0, new CeldaViva());
        tablero.setCelda(2, 1, new CeldaViva());
        tablero.setCelda(2, 2, new CeldaViva());

        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tablero);
        while (!tablero.isEstatico()){
            tablero.sigGeneracion();
            System.out.println("Generación " + i + ":");
            imprimir(tablero);
            i++;
        }
    }

    private static void imprimir(Tablero tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(
                        tablero.getCelda(i, j).estaViva() ? "O " : ". "
                );
            }
            System.out.println();
        }
        System.out.println();
    }
}