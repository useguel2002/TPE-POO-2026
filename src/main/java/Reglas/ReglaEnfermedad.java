package Reglas;

import Celdas.Celda;
import Celdas.CeldaEnferma;
import Celdas.CeldaMuerta;
import Celdas.CeldaViva;

import java.util.Random;

public class ReglaEnfermedad implements Regla{
    private final Random random = new Random();
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        if (actual instanceof CeldaEnferma)
            return new CeldaMuerta();
        if (actual instanceof CeldaViva){
            if (vecVivos ==2 || vecVivos == 3) {
                if (random.nextDouble() < 0.25)
                    return new CeldaEnferma();
                return actual;
            }
            return new CeldaMuerta();
        }
        if (actual instanceof CeldaMuerta){
            if (vecVivos == 3)
                return new CeldaViva();
        }
    return actual;
    }
}
