package Tableros;

import Celdas.Celda;
import Celdas.CeldaMuerta;
import Reglas.Regla;

import java.util.Arrays;
/**
 * Representa el tablero del juego.
 * Contiene una matriz de celdas y la regla que determina cómo evolucionan en cada generación.
 */
public class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private Regla regla;
    /**
     * Constructor del tablero.
     * Inicializa todas las posiciones como celdas muertas.
     */
    public Tablero(int fil, int col, Regla reg){
        this.filas = fil;
        this.columnas = col;
        this.regla = reg;
        celdas = new Celda[fil][col];

        for (int i=0; i<filas; i++)
            for (int j=0; j<columnas; j++){
                celdas[i][j] = new CeldaMuerta();
            }
    }
//SI la celda esta (supongamos) en la fila 3 columna 3, sus vecinos son:
//       |F2C2|F2C3|F2C4| -1-1|-1-0|-1+1
//       |F3C2|F3C3|F3C4| -0-1|-0-0|-0+1
//       |F4C2|F4C3|F4C4| +1-1|+1-0|+1+1
    /**
     * Cuenta la cantidad de vecinos vivos de una celda.
     *
     * Para una celda en posición (fila, columna) se revisan
     * las 8 posiciones adyacentes.
     *
     * Se verifica que las posiciones sean válidas para evitar
     * salir de los límites del tablero.
     */
    public int contarVecinosVivos (int fil, int col){
        //Metodo para contar los vecinos vivos de una celda A. Debe revisar que las filas y
        //columnas sean validas (en caso de que se cuenten los vecinos de una esquina) y luego contar
        //si la celda en esa posicion esta viva. A su vez no debe contarse a si misma.
        int vivos = 0;
        for (int i =-1; i<=1;i++)
            for (int j=-1; j <=1; j++){
                //No cuenta la celda actual
                if (i==0 && j==0) continue;
                if (esValida(fil+i,col+j) && celdas[fil+i][col+j].estaViva()) vivos++;
            }
        return vivos;
    }
    /**
     * Verifica si una posición pertenece al tablero.
     */
    private boolean esValida(int fil, int col) {
        //Devuelve si la fila y columna EXISTEN en el tablero.
        return fil >= 0 && fil < filas &&
                col >= 0 && col < columnas;
    }

    /**
     * Calcula la siguiente generación del tablero.
     *
     * Para cada celda:
     * - Se cuentan los vecinos vivos
     * - Se aplica la regla correspondiente
     *
     * Se utiliza una matriz auxiliar para evitar modificar
     * el tablero mientras se calcula la nueva generación. (Como pedia el enunciado)
     *
     * Retorna true si el tablero no cambia (estado estable)
     */
    public boolean sigGeneracion(){
        //Metodo para calcular la proxima generacion de celdas en el tablero. Por cada celda se debe contar la cantidad de
        //vecinos, y a razon de su cantidad determinar si mueren, viven o se mantiene el estado actual.
        //Se usa un tablero auxiliar para no modificar el actual en cada instancia y calcular erroneamente.
        Celda[][] nuevoEstado = new Celda[filas][columnas];
        for (int i=0; i< filas; i++)
            for (int j=0; j<columnas; j++){
                int vecVivos = contarVecinosVivos(i,j);
                nuevoEstado[i][j] = regla.aplicar(celdas[i][j],vecVivos);
            }
        if (Arrays.deepEquals(celdas, nuevoEstado)){
            return true;
        } else{
            celdas = nuevoEstado;
            return false;
        }
    }

    /**
     * GETTERS Y SETTERS
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public int getFilas() {
        return filas;
    }
    public void setCelda(int fil, int col, Celda celda) {
        celdas[fil][col] = celda;
    }
    public Celda getCelda(int fil, int col){
        //Metodo para devolver una celda en especifico.
        return celdas[fil][col];
    }
}
