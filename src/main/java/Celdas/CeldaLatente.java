package Celdas;
/**
 * Representa una celda latente.
 * Hereda de CeldaMuerta, por lo que se considera muerta, pero puede activarse por reglas especiales.
 * Si tiene en su vecindad exactamente una (1) celda viva, esta celda se convierte en viva.
 *
 * NOTA: Al considerarse muerta tambien se le aplican la regla basica: si tiene tres (3) vecinas vivas tambien
 * pasa a viva. Debi preguntar por especificación de si esta regla aplicaba o no en las latentes tambien.
 */
public class CeldaLatente extends CeldaMuerta{
    public boolean esLatente() {
        /**
         * Indica que la celda se encuentra en estado latente.
         * No es utilizado
         */
        return true;
    }
}
