package Reglas;

import Celdas.*;
import java.util.List;
//Si quiero combinar varias reglas en una uso esta clase. Para no crear reglas con todas las combinaciones posibles
//Es decir, no hacer esto: ReglaEnfermedadLatente, ReglaEnfermedadZombie, etc.
//Aun asi hay que tenr cuidado. Hay que ordenar bien las reglas ára que no se pisen o se apliquen las bases antes que las especiales
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
            // Sino corre riesgo de pisarla otra regla posterior
            if (nueva != resultado) return nueva;
            resultado = nueva;
        }
        return resultado;
    }
}