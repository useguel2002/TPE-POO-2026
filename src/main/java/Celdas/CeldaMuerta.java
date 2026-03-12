package Celdas;
/**
 * Representa una celda muerta del tablero.
 */
public class CeldaMuerta extends Celda{
    public boolean estaViva(){
        /**
         * Una celda muerta siempre se considera no viva.
         */
        return false;
    };
}
