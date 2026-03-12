package Reglas;

import Celdas.*;
import java.util.Random;
/**
 * Regla que introduce enfermedad en las células vivas. Extiende de Regla Basica, solo
 * agrega los metodos para las celdas enfermas
 *
 * Comportamiento:
 * - Una celda enferma muere en la siguiente generación.
 * - Una celda viva tiene 25% de probabilidad de enfermarse.
 * - Si no se enferma, evoluciona según las reglas básicas.
 */
public class ReglaEnfermedad extends ReglaBasica { //posiblemente deba usar simplemente extends Regla
    private final Random random = new Random();
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        if (actual instanceof CeldaEnferma)
            return new CeldaMuerta();
        //El enunciado indica que primero debe evaluarse si se enferma o no...
        if (actual instanceof CeldaViva) {
            if (random.nextDouble() < 0.25)
                return new CeldaEnferma();
        }
        //... y si no se enferma evoluciona como se describio anteriormente, es decir, a traves de Regla Basica. (super)
        return super.aplicar(actual, vecVivos);
    }
}
