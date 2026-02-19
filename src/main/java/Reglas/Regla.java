package Reglas;

import Celdas.Celda;

public interface Regla {
    Celda aplicar(Celda actual, int vecVivos);
}
