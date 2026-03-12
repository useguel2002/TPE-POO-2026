package Celdas;
/**
 * Clase abstracta que representa una celda del tablero.
 * Todas las celdas deben indicar si se consideran vivas para las reglas del Juego de la Vida.
 */
public abstract class Celda {
    /**
     * Indica si la celda se considera viva. Las subclases derivadas la implementan.
     */
    public abstract boolean estaViva();
}

