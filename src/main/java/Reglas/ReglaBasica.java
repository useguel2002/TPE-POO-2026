package Reglas;

import Celdas.*;
/**
 * Implementa las reglas básicas del Juego de la Vida.
 *
 * Reglas:
 * - Una celda viva sobrevive si tiene 2 o 3 vecinos vivos.
 * - Una celda viva muere por soledad (menos de 2 vecinos) o sobrepoblación (más de 3 vecinos).
 * - Una celda muerta revive si tiene EXACTAMENTE 3 vecinos vivos.
 */
public class ReglaBasica implements Regla{
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        if (actual instanceof CeldaViva){
            if (vecVivos ==2 || vecVivos == 3) return actual;
            return new CeldaMuerta();
        }
        if (actual instanceof CeldaMuerta){
            if (vecVivos == 3) return new CeldaViva();
        }
        return actual;
    }
}
