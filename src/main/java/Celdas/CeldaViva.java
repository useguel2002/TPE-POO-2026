package Celdas;
/**
 * Representa una celda viva del tablero.
 * Participa e interactua en el ciclo de vida del resto de celdas del tablero
 */
public class CeldaViva extends Celda{
    public boolean estaViva(){
        /**
         * Una celda viva siempre se considera viva.
         */
        return true;
    };
}
