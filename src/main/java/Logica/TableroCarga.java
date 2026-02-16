package Logica;

import java.io.*;
import java.util.Random;

public class TableroCarga {
    public static Tablero desdeArchivo(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String[] dimensiones = br.readLine().split(" ");
        int filas = Integer.parseInt(dimensiones[0]);
        int columnas = Integer.parseInt(dimensiones[1]);
        Tablero tablero = new Tablero(filas, columnas);
        for (int i = 0; i < filas; i++) {
            String linea = br.readLine();
            for (int j = 0; j < columnas; j++) {
                char c = linea.charAt(j);
                if (c == 'x' ) {
                    tablero.setCelda(i, j, new CeldaViva());
                } else {
                    tablero.setCelda(i, j, new CeldaMuerta());
                }
            }
        }
        br.close();
        return tablero;
    }

    public static Tablero aleatorio(int filas, int columnas, double probabilidadVida) {
        Tablero tablero = new Tablero(filas, columnas);
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (random.nextDouble() < probabilidadVida) {
                    tablero.setCelda(i, j, new CeldaViva());
                }
            }
        }
        return tablero;
    }
}
