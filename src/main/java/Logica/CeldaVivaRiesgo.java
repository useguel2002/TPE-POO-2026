package Logica;

import java.util.Random;

public class CeldaVivaRiesgo extends CeldaViva{
    @Override
    public Celda siguienteEstado(int vecVivos){
        final Random random = new Random();
        if (vecVivos ==2 || vecVivos == 3) {
            if (random.nextDouble() < 0.25) return new CeldaEnferma();
            return this;
        }
        return new CeldaMuerta();
    };
}
