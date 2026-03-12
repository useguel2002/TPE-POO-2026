package org.example.Juego_De_La_Vida;

import Celdas.*;
import Reglas.*;
import Tableros.Tablero;
import Tableros.TableroCarga;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Versión de consola del Juego de la Vida. Se utilizo para corroborar en primera instancia lo hecho en JavaFX
 * Permite seleccionar reglas, cargar un tablero desde archivo
 * o generarlo aleatoriamente, y luego simular su evolución.
 */
public class JuegoDeLaVidaConsola {
    // Regla que se aplicará al tablero
    private static Regla regla;
    /**
     * Imprime el estado actual del tablero en consola.
     * Cada tipo de celda se representa con un símbolo:
     * E = enferma
     * L = latente
     * O = viva
     * . = muerta
     *
     * Se puede extender facilmente
     */
    private static void imprimir(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero.getCelda(i,j) instanceof CeldaEnferma)
                    System.out.print("E "); //enferma
                else if (tablero.getCelda(i,j) instanceof CeldaLatente)
                    System.out.print("L "); //latente
                else if (tablero.getCelda(i,j).estaViva())
                    System.out.print("O "); //Celda Viva
                else
                    System.out.print(". "); //Celda muerta
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Solicita al usuario la cantidad de generaciones a simular.
     * Si el usuario ingresa 0, la simulación será indefinida
     * hasta que el tablero se vuelva estable/infinita si es un oscilador (Ejemplo 1.txt)
     */
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
    /**
     * Ejecuta la simulación del juego. Muestra el estado inicial y luego cada generación
     * hasta llegar al número solicitado o hasta que el tablero se vuelva estable.
     */
    private static void simular(Tablero tablero){
        //imprime lo primero que hay en el archivo.
        int n = setGeneracion();
        int i = 1;
        System.out.println("Estado Inicial:");
        imprimir(tablero);
        //Simula indefinidamente o hasta un estado estable
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
        //Simula hasta generacion solicitada (o antes si el tablero queda estable antes de lo solicitado)
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
    /**
     * Método principal del programa.
     * Permite al usuario:
     * - seleccionar reglas
     * - elegir origen del tablero
     * - iniciar la simulación
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero;
        // Selección de reglas
        System.out.println("ELECCIÓN DE REGLAS ESPECIALES");
        List<Regla> reglasSeleccionadas = new ArrayList<>();
        System.out.print("¿Activar regla Enfermedad? (s/n): ");
        if (scanner.next().equalsIgnoreCase("s")) {
            reglasSeleccionadas.add(new ReglaEnfermedad());
        }
        System.out.print("¿Activar regla Latente? (s/n): ");
        if (scanner.next().equalsIgnoreCase("s")) {
            reglasSeleccionadas.add(new ReglaLatente());
        }
        // La básica siempre al final y es obligatoria
        reglasSeleccionadas.add(new ReglaBasica());
        regla = new ReglaCombinacion(reglasSeleccionadas);
        try {
            int opcion;
            while (true) {
                System.out.println("=== Juego de la Vida ===");
                System.out.println("1 - Cargar desde archivo");
                System.out.println("2 - Generar tablero aleatorio");
                System.out.print("Seleccione una opción: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 1 || opcion == 2) {
                        break;
                    } else {
                        System.out.println("Opción inválida. Intente nuevamente.\n");
                    }
                } else {
                    System.out.println("Debe ingresar un número.\n");
                    scanner.next();
                }
            }
            if (opcion == 1) {
                System.out.println("Archivos disponibles:");
                System.out.println("1 - Ejemplo 1.txt (Oscilador)");
                System.out.println("2 - Ejemplo 2.txt");
                System.out.println("3 - Ejemplo 3.txt (Nombre Alumno)");
                System.out.println("4 - Ejemplo 4.txt (Prueba Regla Latente)");
                System.out.println("5 - Ejemplo 5.txt (Archivo delimitado pero vacio. Prueba de error)");
                System.out.println("6 - Ejemplo 6.txt (Archivo no delimitado. Prueba de error)");
                System.out.println("7 - Ejemplo 7.txt (Archivo totalmente vacio. Prueba de error)");
                System.out.print("Seleccione archivo: ");
                int archivo = scanner.nextInt();
                String ruta;
                switch (archivo) {
                    case 1:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 1.txt";
                        break;
                    case 2:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 2.txt";
                        break;
                    case 3:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 3.txt";
                        break;
                    case 4:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 4.txt";
                        break;
                    case 5:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 5.txt";
                        break;
                    case 6:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 6.txt";
                        break;
                    case 7:
                        ruta = "src/main/resources/Ejemplos/Ejemplo 7.txt";
                        break;
                    default:
                        ruta = "ARCHIVO INEXISTENTE";
                        break;
                }
                tablero = TableroCarga.desdeArchivo(ruta, regla);
            } else {
                System.out.print("Filas: ");
                int filas = scanner.nextInt();
                System.out.print("Columnas: ");
                int columnas = scanner.nextInt();
                System.out.print("Probabilidad de vida (0,0 - 1,0): ");
                double prob = scanner.nextDouble();
                tablero = TableroCarga.aleatorio(filas, columnas, prob, regla);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tablero: " + e.getMessage());
            return;
        }
        simular(tablero);
    }

}