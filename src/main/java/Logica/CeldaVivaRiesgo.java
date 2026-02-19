package Logica;

import java.util.Random;

public class CeldaVivaRiesgo extends CeldaViva{
    private static final Random random = new Random();
    @Override
    public Celda siguienteEstado(int vecVivos){
        if (vecVivos ==2 || vecVivos == 3) {
            if (random.nextDouble() < 0.25) return new CeldaEnferma();
            return this;
        }
        return new CeldaMuerta();
    }
}
