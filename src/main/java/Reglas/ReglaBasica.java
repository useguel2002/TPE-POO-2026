package Reglas;

import Celdas.*;

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
