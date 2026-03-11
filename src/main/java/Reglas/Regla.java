package Reglas;

import Celdas.*;

public interface Regla {
    Celda aplicar(Celda actual, int vecVivos);
}
