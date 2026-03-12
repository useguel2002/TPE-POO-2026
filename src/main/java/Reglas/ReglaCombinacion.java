package Reglas;

import Celdas.*;
import java.util.List;
/**
 * Permite combinar múltiples reglas en una sola.
 *
 * Esto evita tener que crear clases para todas las combinaciones
 * posibles de reglas (por ejemplo: ReglaEnfermedadLatente,
 * ReglaEnfermedadZombie, etc.).
 *
 * Las reglas se aplican en el orden definido en la lista. (Por iseño, ReglaBasica siempre ira al final.)
 * Si una regla modifica el estado de la celda, se detiene
 * la evaluación para evitar que otra regla posterior sobrescriba el cambio.
 */
public class ReglaCombinacion implements Regla {
    private List<Regla> reglas;
    public ReglaCombinacion(List<Regla> reglas) {
        this.reglas = reglas;
    }
    @Override
    public Celda aplicar(Celda actual, int vecVivos) {
        Celda resultado = actual;
        //Se aplica regla por regla
        for (Regla r : reglas) {
            Celda nueva = r.aplicar(resultado, vecVivos);
            //Si una regla modifica una celda, esta ebe retornar e interrumpir la caena.
            //Sino corre riesgo de pisarla otra regla posterior
            if (nueva != resultado) return nueva;
            resultado = nueva;
        }
        return resultado;
    }
}