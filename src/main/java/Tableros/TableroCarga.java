package Tableros;

import Celdas.*;
import Reglas.*;

import java.io.*;
import java.util.Random;

public class TableroCarga {
    public static Tablero desdeArchivo(String ruta, Regla regla) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String primeraLinea = br.readLine();
        if (primeraLinea == null)
            throw new IOException("Archivo vacío.");
        String[] dimensiones = br.readLine().split(" ");
        if (dimensiones.length != 2)
            throw new IOException("La primera línea debe indicar filas y columnas.");
        int filas = Integer.parseInt(dimensiones[0]);
        int columnas = Integer.parseInt(dimensiones[1]);
        Tablero tablero = new Tablero(filas, columnas, regla);
        for (int i = 0; i < filas; i++) {
            String linea = br.readLine();
            if (linea == null) {
                throw new IOException("El archivo no contiene suficientes filas.");
            }
            for (int j = 0; j < columnas; j++) {
                char c = linea.charAt(j);
                if (c == 'x' ) { //viva
                    tablero.setCelda(i, j, new CeldaViva());
                } else if (c == 'e' ) { //enferma
                    tablero.setCelda(i, j, new CeldaEnferma());
                } else if (c == 'l' ) { //latente
                    tablero.setCelda(i, j, new CeldaLatente());
                } else{
                    tablero.setCelda(i, j, new CeldaMuerta());
                }
            }
        }
        br.close();
        return tablero;
    }

    public static Tablero aleatorio(int filas, int columnas, double probabilidadVida, Regla regla) {
        Tablero tablero = new Tablero(filas, columnas, regla);
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
