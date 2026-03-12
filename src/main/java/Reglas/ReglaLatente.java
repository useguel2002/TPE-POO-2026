package Reglas;

import Celdas.*;
import java.util.Random;

public class ReglaLatente extends ReglaBasica {
    private final Random random = new Random();
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        if (actual instanceof CeldaLatente) {
            if (vecVivos == 1)
                return new CeldaViva();
        }
        return actual; //super.aplicar(actual, vecVivos);
    }
}
