package Reglas;

import Celdas.*;
/**
 * Interfaz que define una regla de evolución para las celdas del tablero.
 *
 * Cada implementación determina cómo cambia el estado de una celda
 * según su estado actual y la cantidad de vecinos vivos en (vecino es aquel a una distancia de una
 * celda, ya sea arriba, abajo, derecha, izquierda o en diagonal).
 */
public interface Regla {
    /**
     * Aplica la regla sobre una celda.
     *
     * actual: estado actual de la celda
     * vecVivos: cantidad de vecinos vivos
     * Retorna la nueva celda resultante luego de aplicar la regla
     */
    Celda aplicar(Celda actual, int vecVivos);
}
