package Reglas;

import Celdas.*;
import java.util.Random;

public class ReglaEnfermedad extends ReglaBasica {
    private final Random random = new Random();
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        //Como solo extendemos ReglaBasica solo agregamos los metodos para la celda enferma.
        if (actual instanceof CeldaEnferma)
            return new CeldaMuerta();
        //El enunciado indica que primero debe evaluarse si se enferma o no...
        if (actual instanceof CeldaViva) {
            if (random.nextDouble() < 0.25)
                return new CeldaEnferma();
        }
        //... y si no se enferma evoluciona como se describio anteriormente, es decir, a traves de Regla Basica.
        return super.aplicar(actual, vecVivos);
    }
}
