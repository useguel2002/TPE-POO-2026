package Logica;

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
}
