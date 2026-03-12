package Reglas;

import Celdas.*;
import java.util.Random;
/**
 * Regla que define el comportamiento de las celdas latentes.
 *
 * Una celda latente revive si tiene exactamente un vecino vivo en su vecindad.
 *
 * Ver NOTA en CeldaLatente
 */
public class ReglaLatente extends ReglaBasica {
    private final Random random = new Random();
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        if (actual instanceof CeldaLatente) {
            if (vecVivos == 1)
                return new CeldaViva();
        }
        return super.aplicar(actual, vecVivos);
    }
}
