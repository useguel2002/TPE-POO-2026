package Tableros;

import Celdas.Celda;
import Celdas.CeldaMuerta;

import java.util.Arrays;

public class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;

    public Tablero(int fil, int col){
        this.filas = fil;
        this.columnas = col;
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
    private boolean esValida(int fil, int col) {
        //Devuelve si la fila y columna EXISTEN en el tablero.
        return fil >= 0 && fil < filas &&
                col >= 0 && col < columnas;
    }

    public boolean sigGeneracion(){
        //Metodo para calcular la proxima generacion de celdas en el tablero. Por cada celda se debe contar la cantidad de
        //vecinos, y a razon de su cantidad determinar si mueren, viven o se mantiene el estado actual.
        //Se usa un tablero auxiliar para no modificar el actual en cada instancia y calcular erroneamente.
        Celda[][] nuevoEstado = new Celda[filas][columnas];
        for (int i=0; i< filas; i++)
            for (int j=0; j<columnas; j++){
                int vecVivos = contarVecinosVivos(i,j);
                nuevoEstado[i][j] = celdas[i][j].siguienteEstado(vecVivos);
            }
        if (Arrays.deepEquals(celdas, nuevoEstado)){
            return true;
        } else{
            celdas = nuevoEstado;
            return false;
        }
    }

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
