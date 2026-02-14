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
//SI la celda esta (supongamos) en la fila 3 columna 3, sus vecinos son:
//       |F2C2|F2C3|F2C4| -1-1|-1-0|-1+1
//       |F3C2|F3C3|F3C4| -0-1|-0-0|-0+1
//       |F4C2|F4C3|F4C4| +1-1|+1-0|+1+1
    public int contarVecinosVivos (int fil, int col){
        int vivos = 0;
        for (int i =-1; i<=1;i++)
            for (int j=-1; j <=1; j++){
                if (esValida(fil,col) && celdas[fil-i][col-j].estaViva()) vivos++;
            }
        return vivos;
    }



    private boolean esValida(int fil, int col) {
        //Devuelve si la fila y columna EXISTEN en el tablero.
        return fil >= 0 && fil < filas &&
                col >= 0 && col < columnas;
    }
    public Celda getCelda(int fil, int col){
        //Metodo para devolver una celda en especifico.
        return celdas[fil][col];
    }
}
