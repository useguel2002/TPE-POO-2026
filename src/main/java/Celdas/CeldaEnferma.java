package Celdas;
/**
 * Representa una celda viva pero afectada por enfermedad.
 * Hereda el comportamiento de CeldaViva, por lo que sigue
 * siendo considerada viva. Interactua con las vecinas como celda viva, pero morira siempre en la siguiente generación.
 */
public class CeldaEnferma extends CeldaViva {
    public boolean estaEnferma() {
        /**
         * Indica que la celda está enferma.
         * Este método no es utilizado. Se usa instanceOf
         */
        return true;
    }
}
